package com.hedongxing.track.achievement.infrastructure.event;

import com.hedongxing.track.achievement.model.AccomplishedAchievement;
import org.springframework.context.ApplicationEvent;

public class AchievementAccomplishedEvent extends ApplicationEvent {

    private String childId;

    private AccomplishedAchievement accomplishedAchievement;

    public AchievementAccomplishedEvent(Object source, String childId, AccomplishedAchievement accomplishedAchievement) {
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