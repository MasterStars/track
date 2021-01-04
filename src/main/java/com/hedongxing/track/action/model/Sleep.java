package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class Sleep extends Action {

    private LocalDateTime sleepTime;

    private LocalDateTime wakeTime;

    public Sleep(LocalDateTime sleepTime, LocalDateTime wakeTime) {
        super("sleep", sleepTime);
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
    }

    @Override
    public void execute(Child child) {
        Map<String, Object> childProperties = child.getProperties();

        long sleepHours = Duration.between(sleepTime, wakeTime).toHours();

        childProperties.put("single-sleep-hours", sleepHours);

        long totalHours = sleepHours;
        if(childProperties.containsKey("total-sleep-hours")) {
            totalHours += (Integer) childProperties.get("total-sleep-hours");
        }
        childProperties.put("total-sleep-hours", totalHours);

        child.updateAccomplishedAchievements();
    }
}
