package com.hedongxing.track.achievement.infrastructure.event;

import com.hedongxing.track.achievement.model.Property;
import org.springframework.context.ApplicationEvent;

public class ChildPropertyUpdated extends ApplicationEvent {

    private String childId;

    private Property updatedProperty;

    private Long updatedValue;

    public ChildPropertyUpdated(Object source, String childId, Property updatedProperty, Long updatedValue) {
        super(source);
        this.childId = childId;
        this.updatedProperty = updatedProperty;
        this.updatedValue = updatedValue;
    }

    public String getChildId() {
        return childId;
    }

    public Property getUpdatedProperty() {
        return updatedProperty;
    }

    public Long getUpdatedValue() {
        return updatedValue;
    }
}
