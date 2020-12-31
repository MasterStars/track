package com.hedongxing.track.model.achievement;

import com.hedongxing.track.model.action.Action;
import com.hedongxing.track.model.action.Sleep;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * “睡梦罗汉”成就
 */
public class SleepLohan implements Achievement {

    @Override
    public int getScore() {
        return 10;
    }

    @Override
    public boolean isAccomplishedOn(Action action) {
        if(action instanceof Sleep) {
            Sleep sleep = (Sleep)action;
            if(isAtDaytime(sleep.getSleepTime())){
                Duration duration = Duration.between(sleep.getSleepTime(), sleep.getWakeTime());
                return duration.toHours() > 4;
            }

        }
        return false;
    }

    private boolean isAtDaytime(LocalDateTime localDateTime) {
        return localDateTime.getHour() > 6 && localDateTime.getHour() < 18;
    }
}
