package com.hedongxing.track.property.model.action;

import com.hedongxing.track.property.model.Action;
import com.hedongxing.track.property.model.Property;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class AbstractAction {

    public abstract String actionCode();

    public abstract Map<Property, Long> gainedProperties();

    public abstract Map<Property, Long> replacedProperties();

    public abstract String detail();

    public abstract LocalDateTime actionTime();

    public Action toAction() {
        return new Action(actionCode(), actionTime(), gainedProperties(), replacedProperties(), detail());
    }
}
