package com.hedongxing.track.achievement.infrastructure.event;

import com.hedongxing.track.achievement.model.Action;
import org.springframework.context.ApplicationEvent;

public class ActionCompletedEvent extends ApplicationEvent {

    private String childId;

    private Action action;

    public ActionCompletedEvent(Object source, String childId, Action action) {
        super(source);
        this.childId = childId;
        this.action = action;
    }

    public String getChildId() {
        return childId;
    }

    public Action getAction() {
        return action;
    }
}
