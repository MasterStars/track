package com.hedongxing.track.achievement.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Achievement {

    private String name;

    private Integer score;

    private Map<Property, Long> properties;

    private Operator operator;

    public Achievement(String name, Integer score, Map<Property, Long> properties) {
        this.name = name;
        this.score = score;
        this.properties = new HashMap<>(properties);
        this.operator = Operator.AND;
    }

    public Achievement(String name, Integer score, Map<Property, Long> properties, Operator operator) {
        this.name = name;
        this.score = score;
        this.properties = new HashMap<>(properties);
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Achievement) {
            Achievement achievement = (Achievement)o;
            return achievement.getName().equals(name);
        }
        return false;
    }
}
