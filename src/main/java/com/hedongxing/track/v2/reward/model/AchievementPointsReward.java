package com.hedongxing.track.v2.reward.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 成就分奖励
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AchievementPointsReward {

    String id;

    String name;

    Integer achievementPoints;
}
