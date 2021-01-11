package com.hedongxing.track.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("achievement_property")
public class AchievementPropertyPO {

    String id;

    String achievementId;

    String propertyId;

    /**
     * 临界值
     */
    Long criticalValue;
}
