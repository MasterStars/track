package com.hedongxing.track.achievement.model;

import com.hedongxing.track.action.model.Action;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
public class Child {

    private String name;

    private Map<String, Object> properties;

    private List<AccomplishedAchievement> accomplishedAchievements;

    public Child(String name) {
        this.name = name;
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

    private boolean hasProperty(String key) {
        return properties.containsKey(key);
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
        Map<String, Object> achievementProperties = achievement.getProperties();
        for(String key : achievementProperties.keySet()) {
            Object criticalValue = achievementProperties.get(key);
            if(!reachesTheCriticalValue(properties.get(key), criticalValue)){
                return false;
            }
        }
        return true;
    }

    private boolean reachesTheCriticalValue(Object nowValue, Object criticalValue) {
        if(nowValue.getClass() == Integer.class &&
            criticalValue.getClass() == Integer.class) {
            Integer nowVal = (Integer)nowValue;
            Integer criticalVal = (Integer)criticalValue;
            return nowVal >= criticalVal;
        }
        if(nowValue.getClass() == Float.class &&
                criticalValue.getClass() == Float.class){
            Float nowVal = (Float)nowValue;
            Float criticalVal = (Float)criticalValue;
            return nowVal >= criticalVal;
        }
        if(nowValue.getClass() == Double.class &&
                criticalValue.getClass() == Double.class){
            Double nowVal = (Double)nowValue;
            Double criticalVal = (Double)criticalValue;
            return nowVal >= criticalVal;
        }
        if(nowValue.getClass() == BigDecimal.class &&
                criticalValue.getClass() == BigDecimal.class){
            BigDecimal nowVal = (BigDecimal)nowValue;
            BigDecimal criticalVal = (BigDecimal)criticalValue;
            return nowVal.compareTo(criticalVal) > -1;
        }
        return false;
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
