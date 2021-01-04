package com.hedongxing.track.achievement.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AchievementPropertyPO {

    String id;

    String achievementId;

    String propertyId;

    /**
     * 临界值
     */
    String criticalValue;
}
