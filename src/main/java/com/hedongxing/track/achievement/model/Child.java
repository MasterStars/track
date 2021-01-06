package com.hedongxing.track.achievement.model;

import com.hedongxing.track.achievement.infrastructure.event.AchievementAccomplishedEvent;
import com.hedongxing.track.action.model.Action;
import com.hedongxing.track.action.model.ActionRepository;
import com.hedongxing.track.infrastructure.util.SpringBeanUtil;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class Child {

    private String id;

    private String name;

    private ChildProperties properties;

    private AccomplishedAchievements accomplishedAchievements;

    private Child(String id, String name) {
        this.id = id;
        this.name = name;
        Map<Property, Long> propertyMap = new HashMap<>();
        for(Property property : PropertyRepository.allPrperties()) {
            propertyMap.put(property, 0L);
        }
        properties = new ChildProperties(id, propertyMap);
        accomplishedAchievements = new AccomplishedAchievements(new ArrayList<>());
    }

    public Child(String id, String name, ChildProperties properties, AccomplishedAchievements accomplishedAchievements) {
        this.id = id;
        this.name = name;
        this.properties = properties;
        this.accomplishedAchievements = accomplishedAchievements;
    }

    public static Child newChild(String name) {
        return new Child(UUID.randomUUID().toString(), name);
    }

    public void updateAccomplishedAchievements() {
        for(Achievement achievement : AchievementRepository.allAchievements()) {
            if(!hasAlreadyAccomplished(achievement) && achievement.isAchievedBy(properties)) {
                accomplishedAchievements.addNewAchievement(achievement);
                SpringBeanUtil.publishEvent(new AchievementAccomplishedEvent(this, id, new AccomplishedAchievement(achievement, LocalDateTime.now())));
            }
        }
    }

    private boolean hasAlreadyAccomplished(Achievement achievement) {
        for(AccomplishedAchievement accomplishedAchievement : accomplishedAchievements.getAccomplishedAchievements()) {
            if(accomplishedAchievement.getAchievement().equals(achievement)) {
                return true;
            }
        }
        return false;
    }

    public void complete(Action action) {
        action.beDoneBy(this);
    }

    public String printAccomplishedAchievements() {
        updateAccomplishedAchievements();
        String accomplishedAchievementsPrinter = name + "成就榜: " + "\n";
        int points = 0;
        for(AccomplishedAchievement accomplishedAchievement : accomplishedAchievements.getAccomplishedAchievements()) {
            accomplishedAchievementsPrinter += accomplishedAchievement.getAchievement().getName() + ": " + accomplishedAchievement.getAchievement().getScore() + "\n";
            points += accomplishedAchievement.getAchievement().getScore();
        }
        accomplishedAchievementsPrinter += "当前成就分: " + points;
        return accomplishedAchievementsPrinter;
    }

    public String printActionDetails() {
        StringBuilder details = new StringBuilder();
        for(Action action : ActionRepository.allActions()) {
            details.append(action.printDetail());
            details.append("\n");
        }
        return details.toString();
    }
}
