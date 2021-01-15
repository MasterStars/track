package com.hedongxing.track.v2.deed.application.impl;

import com.hedongxing.track.v2.deed.application.DeedApplication;
import com.hedongxing.track.v2.deed.application.SubjectDeedApplication;
import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedInvalidConfirmed;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedInvalidReset;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedSubmitted;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedValidConfirmed;
import com.hedongxing.track.v2.management.application.RewardReleaserApplication;
import com.hedongxing.track.v2.management.application.SupervisorApplication;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.hedongxing.track.v2.infrastructure.support.EventPublisher.PUBLISH;

@RequiredArgsConstructor
public class DeedApplicationImpl implements DeedApplication {

    private final SupervisorApplication supervisorApplication;

    private final RewardReleaserApplication rewardReleaserApplication;

    private final SubjectDeedApplication subjectDeedApplication;

    @Override
    public void submitDeed(String submitterId, String subjectId, String deedId, LocalDateTime completeTime) {
        SubjectDeed subjectDeed;
        if(submitterIsSubject(submitterId, subjectId)){
            subjectDeed = SubjectDeed.builder()
                    .id(UUID.randomUUID().toString())
                    .subjectId(subjectId)
                    .deedId(deedId)
                    .status(1)
                    .completeTime(completeTime)
                    .submitTime(LocalDateTime.now()).build();
            PUBLISH(new SubjectDeedSubmitted(subjectDeed));
        }else if(submitterIsRewardReleaser(submitterId, subjectId)) {
            subjectDeed = SubjectDeed.builder()
                    .id(UUID.randomUUID().toString())
                    .subjectId(subjectId)
                    .deedId(deedId)
                    .status(2)
                    .completeTime(completeTime)
                    .submitTime(LocalDateTime.now()).build();
            PUBLISH(new SubjectDeedSubmitted(subjectDeed));
            PUBLISH(new SubjectDeedValidConfirmed(subjectDeed));
        }

    }

    private boolean submitterIsSubject(String submitterId, String subjectId) {
        return submitterId.equals(subjectId);
    }

    private boolean submitterIsRewardReleaser(String submitterId, String subjectId) {
        List<String> rewardReleaserIds = rewardReleaserApplication.getRewardReleaserOfSubject(subjectId);
        return rewardReleaserIds.contains(submitterId);
    }

    @Override
    public void confirmDeedValid(String subjectDeedId, String rewardReleaserId, LocalDateTime confirmTime) {
        SubjectDeed subjectDeed = subjectDeedApplication.getSubjectDeedById(subjectDeedId);
        if(subjectDeed.getStatus() == 1) {
            PUBLISH(new SubjectDeedValidConfirmed(subjectDeed));
        }
    }

    @Override
    public void confirmDeedInvalid(String subjectDeedId, String rewardReleaserId, String reason, LocalDateTime confirmTime) {
        SubjectDeed subjectDeed = subjectDeedApplication.getSubjectDeedById(subjectDeedId);
        if(subjectDeed.getStatus() == 1) {
            PUBLISH(new SubjectDeedInvalidConfirmed(subjectDeed));
        }
    }

    @Override
    public void supervisorSetDeedInvalid(String subjectDeedId, String supervisorId, String reason, LocalDateTime setTime) {
        SubjectDeed subjectDeed = subjectDeedApplication.getSubjectDeedById(subjectDeedId);
        List<String> supervisorIds = supervisorApplication.getSupervisorsOfSubject(subjectDeed.getSubjectId());
        if(supervisorIds.contains(supervisorId) &&
                subjectDeed.getStatus() == 2) {
            PUBLISH(new SubjectDeedInvalidReset(subjectDeed));
        }
    }
}
