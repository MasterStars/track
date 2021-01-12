package com.hedongxing.track.achievement.model.action;

import com.hedongxing.track.achievement.model.Property;
import com.hedongxing.track.achievement.model.PropertyRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Sleep extends AbstractAction {

    private LocalDateTime sleepTime;

    private LocalDateTime wakeTime;

    public Sleep(LocalDateTime sleepTime, LocalDateTime wakeTime) {
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
    }


    @Override
    public String actionCode() {
        return "sleep";
    }

    @Override
    public Map<Property, Long> gainedProperties() {
        Map<Property, Long> map = new HashMap<>();
        map.put(PropertyRepository.getProperty("睡觉总时长"), Duration.between(sleepTime, wakeTime).toHours());
        return map;
    }

    @Override
    public Map<Property, Long> replacedProperties() {
        Map<Property, Long> map = new HashMap<>();
        map.put(PropertyRepository.getProperty("单次睡觉时长"), Duration.between(sleepTime, wakeTime).toHours());
        return map;
    }

    @Override
    public String detail() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("睡觉时间： " + sleepTime + "---" + wakeTime);
        return stringBuilder.toString();
    }

    @Override
    public LocalDateTime actionTime() {
        return sleepTime;
    }
}
