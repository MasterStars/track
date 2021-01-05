package com.hedongxing.track.achievement.infrastructure.po;

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
    Long criticalValue;
}
