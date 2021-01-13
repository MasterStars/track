package com.hedongxing.track.property.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AccomplishedAchievements {

    private List<AccomplishedAchievement> accomplishedAchievements;

    public AccomplishedAchievements(List<AccomplishedAchievement> accomplishedAchievements) {
        this.accomplishedAchievements = accomplishedAchievements;
    }

    public void addNewAchievement(Achievement achievement) {
        accomplishedAchievements.add(new AccomplishedAchievement(achievement, LocalDateTime.now()));
    }
}
