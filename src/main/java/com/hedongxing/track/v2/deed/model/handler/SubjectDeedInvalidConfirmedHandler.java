package com.hedongxing.track.v2.deed.model.handler;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedInvalidConfirmed;
import com.hedongxing.track.v2.infrastructure.mapper.SubjectDeedMapper;
import com.hedongxing.track.v2.infrastructure.po.SubjectDeedPO;
import com.hedongxing.track.v2.infrastructure.support.DomainEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectDeedInvalidConfirmedHandler extends DomainEventHandler<SubjectDeedInvalidConfirmed> {

    private final SubjectDeedMapper subjectDeedMapper;

    @Override
    protected void handle(SubjectDeedInvalidConfirmed event) {
        SubjectDeed subjectDeed = event.getSubjectDeed();

        SubjectDeedPO subjectDeedPO = subjectDeedMapper.selectById(subjectDeed.getId());
        subjectDeedPO.setStatus(SubjectDeed.INVALID);
        subjectDeedMapper.updateById(subjectDeedPO);
    }
}
