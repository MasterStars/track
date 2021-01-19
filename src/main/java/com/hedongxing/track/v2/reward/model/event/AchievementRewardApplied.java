package com.hedongxing.track.v2.reward.model.event;

import com.hedongxing.track.v2.infrastructure.support.DomainEvent;
import com.hedongxing.track.v2.reward.model.AchievementPointsReward;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public class AchievementRewardApplied extends DomainEvent {

    private AchievementPointsReward achievementPointsReward;

    private LocalDateTime applyTime;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public AchievementRewardApplied(Object source,
                                    AchievementPointsReward achievementPointsReward,
                                    LocalDateTime applyTime) {
        super(source);
        this.achievementPointsReward = achievementPointsReward;
        this.applyTime = applyTime;
    }
}
