package com.hedongxing.track.v2.deed.model.event;

import com.hedongxing.track.v2.infrastructure.support.DomainEvent;

public class SubjectDeedInvalidReset extends DomainEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SubjectDeedInvalidReset(Object source) {
        super(source);
    }
}
