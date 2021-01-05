package com.hedongxing.track.achievement.model;

import java.util.Map;

public class ChildProperties {

    private Map<Property, Long> properties;

    public void put(String propertyName, long value) {
        properties.put(PropertyRepository.getProperty(propertyName), value);
    }

    public void put(Property property, long value) {

    }

    public long get(String propertyName) {
        return properties.get(PropertyRepository.getProperty(propertyName));
    }

    public long get(Property property) {
        return properties.get(property);
    }
}