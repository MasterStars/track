package com.hedongxing.track.achievement.model;

import java.util.Collections;
import java.util.Map;

public class ChildProperties {

    private Map<Property, Long> properties;

    public ChildProperties(Map<Property, Long> properties) {
        this.properties = properties;
    }

    public void gainProperty(Property property, long value) {
        long newValue = value;
        if(properties.containsKey(property)) {
            newValue += properties.get(property);
        }
        properties.put(property, newValue);
    }

    public void gainProperties(Map<Property, Long> gainedProperties) {
        for(Property property : gainedProperties.keySet()) {
            gainProperty(property, gainedProperties.get(property));
        }
    }

    public void update(String propertyName, long value) {
        properties.put(PropertyRepository.getProperty(propertyName), value);
    }

    public long get(String propertyName) {
        return properties.get(PropertyRepository.getProperty(propertyName));
    }

    public Map<Property, Long> getProperties() {
        return Collections.unmodifiableMap(properties);
    }
}
