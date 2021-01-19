package com.hedongxing.track.v2.deed.model.event;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.infrastructure.support.DomainEvent;
import lombok.Getter;

@Getter
public class SubjectDeedSubmitted extends DomainEvent {

    private SubjectDeed subjectDeed;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SubjectDeedSubmitted(Object source, SubjectDeed subjectDeed) {
        super(source);
        this.subjectDeed = subjectDeed;
    }
}
