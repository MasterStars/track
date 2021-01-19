package com.hedongxing.track.v2.deed.model.handler;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedValidConfirmed;
import com.hedongxing.track.v2.infrastructure.support.DomainEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectDeedValidConfirmedHandler extends DomainEventHandler<SubjectDeedValidConfirmed> {

    @Override
    protected void handle(SubjectDeedValidConfirmed event) {
        SubjectDeed subjectDeed = event.getSubjectDeed();
        subjectDeed.setStatus(SubjectDeed.VALID);
        //TODO 持久化

    }
}
