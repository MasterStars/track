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

import static com.hedongxing.track.v2.infrastructure.support.EventBus.PublishEvent;

@RequiredArgsConstructor
public class DeedApplicationImpl implements DeedApplication {

    private final SupervisorApplication supervisorApplication;

    private final RewardReleaserApplication rewardReleaserApplication;

    private final SubjectDeedApplication subjectDeedApplication;

    @Override
    public void submitDeed(String submitterId, String subjectId, String deedId, String attachments, LocalDateTime completeTime) {
        SubjectDeed subjectDeed;
        if(submitterIsSubject(submitterId, subjectId)){
            subjectDeed = SubjectDeed.builder()
                    .id(UUID.randomUUID().toString())
                    .subjectId(subjectId)
                    .deedId(deedId)
                    .submitterId(submitterId)
                    .build();
            PublishEvent(new SubjectDeedSubmitted(this, subjectDeed, completeTime, LocalDateTime.now()));
        }else if(submitterIsRewardReleaser(submitterId, subjectId)) {
            subjectDeed = SubjectDeed.builder()
                    .id(UUID.randomUUID().toString())
                    .subjectId(subjectId)
                    .deedId(deedId)
                    .submitterId(submitterId)
                    .build();
            PublishEvent(new SubjectDeedSubmitted(this, subjectDeed, completeTime, LocalDateTime.now()));
            PublishEvent(new SubjectDeedValidConfirmed(this, subjectDeed, LocalDateTime.now()));
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
            PublishEvent(new SubjectDeedValidConfirmed(this, subjectDeed, confirmTime));
        }
    }

    @Override
    public void confirmDeedInvalid(String subjectDeedId, String rewardReleaserId, String reason, LocalDateTime confirmTime) {
        SubjectDeed subjectDeed = subjectDeedApplication.getSubjectDeedById(subjectDeedId);
        if(subjectDeed.getStatus() == 1) {
            PublishEvent(new SubjectDeedInvalidConfirmed(this, subjectDeed));
        }
    }

    @Override
    public void supervisorSetDeedInvalid(String subjectDeedId, String supervisorId, String reason, LocalDateTime setTime) {
        SubjectDeed subjectDeed = subjectDeedApplication.getSubjectDeedById(subjectDeedId);
        List<String> supervisorIds = supervisorApplication.getSupervisorsOfSubject(subjectDeed.getSubjectId());
        if(supervisorIds.contains(supervisorId) &&
                subjectDeed.getStatus() == 2) {
            PublishEvent(new SubjectDeedInvalidReset(this, subjectDeed));
        }
    }
}
