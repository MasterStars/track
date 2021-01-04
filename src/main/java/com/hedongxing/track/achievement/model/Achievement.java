package com.hedongxing.track.achievement.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Achievement {

    private String name;

    private Integer score;

    private Map<String, Object> properties;

    public Achievement(String name, Integer score, Map<String, Object> properties) {
        this.name = name;
        this.score = score;
        this.properties = new HashMap<>(properties);
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
