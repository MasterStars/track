package com.hedongxing.track.v2.deed.model.handler;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedValidConfirmed;
import com.hedongxing.track.v2.deed.model.message.SubjectDeedCompleted;
import com.hedongxing.track.v2.infrastructure.mapper.SubjectDeedMapper;
import com.hedongxing.track.v2.infrastructure.po.SubjectDeedPO;
import com.hedongxing.track.v2.infrastructure.support.DomainEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.hedongxing.track.v2.infrastructure.support.EventBus.PublishMessage;

@Component
@RequiredArgsConstructor
public class SubjectDeedValidConfirmedHandler extends DomainEventHandler<SubjectDeedValidConfirmed> {

    private final SubjectDeedMapper subjectDeedMapper;

    @Override
    protected void handle(SubjectDeedValidConfirmed event) {
        SubjectDeed subjectDeed = event.getSubjectDeed();

        SubjectDeedPO subjectDeedPO = subjectDeedMapper.selectById(subjectDeed.getId());
        subjectDeedPO.setStatus(SubjectDeed.VALID);
        subjectDeedPO.setConfirmTime(event.getConfirmTime());
        subjectDeedMapper.updateById(subjectDeedPO);

        PublishMessage(new SubjectDeedCompleted(this,
                subjectDeedPO.getSubjectId(),
                subjectDeedPO.getDeedId(),
                subjectDeedPO.getCompleteTime()));
    }
}
