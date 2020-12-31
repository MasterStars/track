package com.hedongxing.track.model.action;

import java.time.LocalDateTime;

public class Sleep extends Action {

    private LocalDateTime sleepTime;

    private LocalDateTime wakeTime;

    public Sleep(LocalDateTime sleepTime, LocalDateTime wakeTime) {
        super(sleepTime);
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
    }

    @Override
    public String actionCode() {
        return "Sleep";
    }

    public LocalDateTime getSleepTime() {
        return sleepTime;
    }

    public LocalDateTime getWakeTime() {
        return wakeTime;
    }
}
