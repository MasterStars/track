package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;

import java.time.LocalDateTime;

public abstract class Action {

    private String name;

    private LocalDateTime actionTime;

    public Action(String name, LocalDateTime actionTime) {
        this.name = name;
        this.actionTime = actionTime;
    }

    public abstract void execute(Child child);
}
