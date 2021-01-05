package com.hedongxing.track.achievement.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Achievement {

    private String name;

    private Integer score;

    private AchievementRequirements achievementRequirements;

    public Achievement(String name, Integer score, AchievementRequirements achievementRequirements) {
        this.name = name;
        this.score = score;
        this.achievementRequirements = achievementRequirements;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Achievement) {
            Achievement achievement = (Achievement)o;
            return achievement.getName().equals(name);
        }
        return false;
    }

    public boolean isAchievedBy(ChildProperties childProperties) {
        return achievementRequirements.isFulfilledBy(childProperties.getProperties());
    }
}
