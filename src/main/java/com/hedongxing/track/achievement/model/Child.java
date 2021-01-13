package com.hedongxing.track.achievement.model;

import com.hedongxing.track.achievement.infrastructure.event.AchievementAccomplished;
import com.hedongxing.track.achievement.infrastructure.event.ActionCompleted;
import com.hedongxing.track.achievement.infrastructure.event.ChildPropertyUpdated;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;

import static com.hedongxing.track.infrastructure.util.SpringBeanUtil.publish;

@Getter
public class Child {

    private String id;

    private String name;

    private ChildProperties childProperties;

    private List<AccomplishedAchievement> accomplishedAchievements;

    private Child(String id, String name) {
        this.id = id;
        this.name = name;
        Map<Property, Long> propertyMap = new HashMap<>();
        for(Property property : PropertyRepository.allPrperties()) {
            propertyMap.put(property, 0L);
        }
        childProperties = new ChildProperties(propertyMap);
        accomplishedAchievements = new ArrayList<>();
    }

    public Child(String id,
                 String name,
                 ChildProperties childProperties,
                 List<AccomplishedAchievement> accomplishedAchievements) {
        this.id = id;
        this.name = name;
        this.childProperties = childProperties;
        this.accomplishedAchievements = accomplishedAchievements;
    }

    public static Child newChild(String name) {
        return new Child(UUID.randomUUID().toString(), name);
    }

    private void updateAccomplishedAchievements() {
        for(Achievement achievement : AchievementRepository.allAchievements()) {
            if(!hasAlreadyAccomplished(achievement) && achievement.isAchievedBy(childProperties)) {
                AccomplishedAchievement newAccomplishedAchievement = new AccomplishedAchievement(achievement, LocalDateTime.now());
                accomplishedAchievements.add(newAccomplishedAchievement);
                publish(new AchievementAccomplished(this, id, newAccomplishedAchievement));
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

        doAction(action);

        updateAccomplishedAchievements();

    }

    private void doAction(Action action) {
        Map<Property, Long> gainedProperties = action.getGainedProperties();
        childProperties.gain(gainedProperties);
        Map<Property, Long> replacedProperties = action.getReplacedProperties();
        childProperties.replace(replacedProperties);

        for(Property property : gainedProperties.keySet()) {
            publish(new ChildPropertyUpdated(this, id, property, childProperties.get(property)));
        }
        for(Property property : replacedProperties.keySet()) {
            publish(new ChildPropertyUpdated(this, id, property, childProperties.get(property)));
        }
        publish(new ActionCompleted(this, id, action));
    }
}
