package com.hedongxing.track.v2.reward.model.event;

import org.springframework.context.ApplicationEvent;

public class AchievementRewardApplied extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public AchievementRewardApplied(Object source) {
        super(source);
    }
}
