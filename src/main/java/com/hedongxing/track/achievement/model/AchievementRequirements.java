package com.hedongxing.track.achievement.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class AchievementRequirements {

    private Map<Property, Long> properties;

    private Operator operator;

    public AchievementRequirements(Map<Property, Long> properties) {
        this.properties = new HashMap<>(properties);
        this.operator = Operator.AND;
    }

    public AchievementRequirements(Map<Property, Long> properties, Operator operator) {
        this.properties = new HashMap<>(properties);
        this.operator = operator;
    }


    public boolean isFulfilledBy(Map<Property, Long> properties) {
        switch(operator) {
            case AND:
                for(Property property : properties.keySet()) {
                    if(properties.get(property) < properties.get(property)) {
                        return false;
                    }
                }
                return true;
            case OR:
                for(Property property : properties.keySet()) {
                    if(properties.get(property) >= properties.get(property)) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
