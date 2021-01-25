package com.hedongxing.track.v2.deed.model.handler;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedSubmitted;
import com.hedongxing.track.v2.infrastructure.mapper.SubjectDeedMapper;
import com.hedongxing.track.v2.infrastructure.po.SubjectDeedPO;
import com.hedongxing.track.v2.infrastructure.support.DomainEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SubjetDeedSubmittedHandler extends DomainEventHandler<SubjectDeedSubmitted> {

    private final SubjectDeedMapper subjectDeedMapper;

    @Override
    protected void handle(SubjectDeedSubmitted event) {
        SubjectDeed subjectDeed = event.getSubjectDeed();

        SubjectDeedPO subjectDeedPO = new SubjectDeedPO();
        subjectDeedPO.setId(UUID.randomUUID().toString());
        subjectDeedPO.setDeedId(subjectDeed.getDeedId());
        subjectDeedPO.setSubjectId(subjectDeed.getSubjectId());
        subjectDeedPO.setAttachments(subjectDeed.getAttachments());
        subjectDeedPO.setStatus(SubjectDeed.PLACED);
        subjectDeedPO.setCompleteTime(event.getCompleteTime());
        subjectDeedPO.setSubmitTime(event.getSubmitTime());
        subjectDeedMapper.insert(subjectDeedPO);
    }
}
