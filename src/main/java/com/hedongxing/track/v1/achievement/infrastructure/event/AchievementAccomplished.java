package com.hedongxing.track.v1.achievement.infrastructure.event;

import com.hedongxing.track.v1.achievement.model.AccomplishedAchievement;
import org.springframework.context.ApplicationEvent;

public class AchievementAccomplished extends ApplicationEvent {

    private String childId;

    private AccomplishedAchievement accomplishedAchievement;

    public AchievementAccomplished(Object source, String childId, AccomplishedAchievement accomplishedAchievement) {
        super(source);
        this.childId = childId;
        this.accomplishedAchievement = accomplishedAchievement;
    }

    public String getChildId() {
        return childId;
    }

    public AccomplishedAchievement getAccomplishedAchievement() {
        return accomplishedAchievement;
    }
}
