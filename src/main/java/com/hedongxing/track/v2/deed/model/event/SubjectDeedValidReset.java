package com.hedongxing.track.v2.deed.model.event;

import org.springframework.context.ApplicationEvent;

public class SubjectDeedValidReset extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SubjectDeedValidReset(Object source) {
        super(source);
    }
}
