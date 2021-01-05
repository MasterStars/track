package com.hedongxing.track.achievement.model;

import com.hedongxing.track.action.model.Action;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            if(!hasAlreadyAccomplished(achievement) && achieve(achievement)) {
                AccomplishedAchievement accomplishedAchievement = new AccomplishedAchievement();
                accomplishedAchievement.setAchievement(achievement);
                accomplishedAchievement.setAccomplishedTime(LocalDateTime.now());
                accomplishedAchievements.add(accomplishedAchievement);
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

    private boolean achieve(Achievement achievement) {
        Map<Property, Long> achievementProperties = achievement.getProperties();
        Operator operator = achievement.getOperator();
        switch(operator) {
            case AND:
                for(Property property : achievementProperties.keySet()) {
                    if(properties.get(property) < achievementProperties.get(property)) {
                        return false;
                    }
                }
                return true;
            case OR:
                for(Property property : achievementProperties.keySet()) {
                    if(properties.get(property) >= achievementProperties.get(property)) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public void complete(Action action) {
        action.execute(this);
    }

    public String printAccomplishedAchievements() {
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
