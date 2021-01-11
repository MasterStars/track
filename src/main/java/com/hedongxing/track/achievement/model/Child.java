package com.hedongxing.track.achievement.model;

import com.hedongxing.track.achievement.infrastructure.event.AchievementAccomplishedEvent;
import com.hedongxing.track.achievement.infrastructure.event.ActionCompletedEvent;
import com.hedongxing.track.achievement.infrastructure.event.ChildPropertyUpdatedEvent;
import com.hedongxing.track.infrastructure.util.SpringBeanUtil;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;

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
        properties = new ChildProperties(propertyMap);
        accomplishedAchievements = new AccomplishedAchievements(new ArrayList<>());
    }

    public Child(String id,
                 String name,
                 ChildProperties properties,
                 AccomplishedAchievements accomplishedAchievements) {
        this.id = id;
        this.name = name;
        this.properties = properties;
        this.accomplishedAchievements = accomplishedAchievements;
    }

    public static Child newChild(String name) {
        return new Child(UUID.randomUUID().toString(), name);
    }

    private void updateAccomplishedAchievements() {
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

    public void updateProperties(String propertyName, long value) {
        properties.update(propertyName, value);
        SpringBeanUtil.publishEvent(new ChildPropertyUpdatedEvent(this, id, PropertyRepository.getProperty(propertyName), value));
    }

    public void complete(Action action) {

        doAction(action);

        updateAccomplishedAchievements();

        recordAction(action);
    }

    private void doAction(Action action) {
        Map<Property, Long> gainedProperties = action.getGainedProperties();
        properties.gainProperties(gainedProperties);
    }

    private void recordAction(Action action) {
        SpringBeanUtil.publishEvent(new ActionCompletedEvent(this, id, action));
    }

    public String printAccomplishedAchievements() {
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
        List<Action> actionRecords = ActionRepository.getChildActions(id);
        StringBuilder details = new StringBuilder();
        for(Action action : actionRecords) {
            details.append(action.getActionTime() + ": " + name + "完成<" + action.getName() + ">,详细: " + action.getActionDetail());
            details.append("\n");
        }
        return details.toString();
    }
}
