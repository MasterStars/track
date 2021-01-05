package com.hedongxing.track.achievement.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AchievementPO {

    String id;

    String name;

    Integer score;

    String operator;
}
