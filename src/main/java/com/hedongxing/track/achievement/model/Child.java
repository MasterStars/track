package com.hedongxing.track.achievement.model;

import com.hedongxing.track.action.model.Action;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Child {

    private String name;

    private ChildProperties properties;

    private List<AccomplishedAchievement> accomplishedAchievements;

    public Child(String name) {
        this.name = name;
        accomplishedAchievements = new ArrayList<>();
        for(Property property : PropertyRepository.allPrperties()) {
            properties.put(property, 0L);
        }
    }

    public void updateAccomplishedAchievements() {
        for(Achievement achievement : AchievementRepository.allAchievements()) {
            if(!hasAlreadyAccomplished(achievement) && achievement.isAchievedBy(properties)) {
                accomplishedAchievements.add(new AccomplishedAchievement(achievement, LocalDateTime.now()));
            }
        }
    }

    private boolean hasAlreadyAccomplished(Achievement achievement) {
        for(AccomplishedAchievement accomplishedAchievement : accomplishedAchievements) {
            if(accomplishedAchievement.getAchievement().equals(achievement)) {
                return true;
            }
        }
        return false;
    }

    public void complete(Action action) {
        action.execute(this);
    }

    public String printAccomplishedAchievements() {
        updateAccomplishedAchievements();
        String accomplishedAchievementsPrinter = name + "成就榜: " + "\n";
        int points = 0;
        for(AccomplishedAchievement accomplishedAchievement : accomplishedAchievements) {
            accomplishedAchievementsPrinter += accomplishedAchievement.getAchievement().getName() + ": " + accomplishedAchievement.getAchievement().getScore() + "\n";
            points += accomplishedAchievement.getAchievement().getScore();
        }
        accomplishedAchievementsPrinter += "当前成就分: " + points;
        return accomplishedAchievementsPrinter;
    }
}
