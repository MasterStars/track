package com.hedongxing.track.achievement.action;

import java.time.LocalDateTime;

public abstract class Action {

    private LocalDateTime actionTime;

    public abstract String actionCode();

    public Action(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }
}
