package com.hedongxing.track.property.model;

import java.util.Collections;
import java.util.Map;

public class ChildProperties {

    private Map<Property, Long> properties;

    public ChildProperties(Map<Property, Long> properties) {
        this.properties = properties;
    }

    public void gain(Property property, long value) {
        long newValue = value;
        if(properties.containsKey(property)) {
            newValue += properties.get(property);
        }
        properties.put(property, newValue);
    }

    public void gain(Map<Property, Long> gainedProperties) {
        for(Property property : gainedProperties.keySet()) {
            gain(property, gainedProperties.get(property));
        }
    }

    public void replace(Property property, long value) {
        properties.put(property, value);
    }

    public void replace(Map<Property, Long> replacedProperties) {
        for(Property property : replacedProperties.keySet()) {
            replace(property, replacedProperties.get(property));
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
