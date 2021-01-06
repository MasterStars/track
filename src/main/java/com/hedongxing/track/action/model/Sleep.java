package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.achievement.model.ChildProperties;

import java.time.Duration;
import java.time.LocalDateTime;

public class Sleep extends Action {

    private static final String SLEEP_CODE = "sleep";

    private LocalDateTime sleepTime;

    private LocalDateTime wakeTime;

    public Sleep(LocalDateTime sleepTime, LocalDateTime wakeTime) {
        super(SLEEP_CODE, sleepTime);
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
    }

    @Override
    public void execute(Child child) {
        ChildProperties childProperties = child.getProperties();

        long sleepSeconds = Duration.between(sleepTime, wakeTime).getSeconds();

        childProperties.update("单次睡眠时长", sleepSeconds);

        long totalSeconds = sleepSeconds + childProperties.get("睡眠总时长");
        childProperties.update("睡眠总时长", totalSeconds);

    }

    @Override
    public String printDetail() {
        return sleepTime + "---" + wakeTime + ": 睡觉" + Duration.between(sleepTime, wakeTime).toHours() + "小时";
    }
}
