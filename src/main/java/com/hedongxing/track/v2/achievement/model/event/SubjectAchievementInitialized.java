package com.hedongxing.track.v2.achievement.model.event;

import com.hedongxing.track.v2.infrastructure.support.DomainEvent;

public class SubjectAchievementInitialized extends DomainEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SubjectAchievementInitialized(Object source) {
        super(source);
    }
}
