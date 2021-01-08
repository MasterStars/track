package com.hedongxing.track.achievement.model;

import java.time.LocalDateTime;

public class Sleep extends Action {

    private LocalDateTime sleepTime;

    private LocalDateTime wakeTime;

    public Sleep(LocalDateTime sleepTime, LocalDateTime wakeTime) {
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
    }

    @Override
    public String getActionDetail() {
        return "";
    }
}
