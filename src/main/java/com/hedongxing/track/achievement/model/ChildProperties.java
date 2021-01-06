package com.hedongxing.track.achievement.model;

import com.hedongxing.track.achievement.infrastructure.event.ChildPropertyUpdatedEvent;
import com.hedongxing.track.infrastructure.util.SpringBeanUtil;

import java.util.Collections;
import java.util.Map;

public class ChildProperties {

    private String childId;

    private Map<Property, Long> properties;

    public ChildProperties(String childId, Map<Property, Long> properties) {
        this.childId = childId;
        this.properties = properties;
    }

    public void update(String propertyName, long value) {
        properties.put(PropertyRepository.getProperty(propertyName), value);
        SpringBeanUtil.publishEvent(new ChildPropertyUpdatedEvent(this, childId, PropertyRepository.getProperty(propertyName), value));
    }

    public long get(String propertyName) {
        return properties.get(PropertyRepository.getProperty(propertyName));
    }

    public Map<Property, Long> getProperties() {
        return Collections.unmodifiableMap(properties);
    }
}
