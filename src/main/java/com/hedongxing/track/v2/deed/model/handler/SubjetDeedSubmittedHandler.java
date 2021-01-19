package com.hedongxing.track.v2.deed.model.handler;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.deed.model.event.SubjectDeedSubmitted;
import com.hedongxing.track.v2.infrastructure.support.DomainEventHandler;
import org.springframework.stereotype.Component;

@Component
public class SubjetDeedSubmittedHandler extends DomainEventHandler<SubjectDeedSubmitted> {

    @Override
    protected void handle(SubjectDeedSubmitted event) {
        SubjectDeed subjectDeed = event.getSubjectDeed();
        //TODO 持久化subjectDeed
    }
}
