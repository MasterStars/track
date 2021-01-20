package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AchievementPointsRewardPO {

    String id;

    String tenantId;

    Integer achievementPoints;

    String rewardId;

    LocalDateTime applyTime;

    LocalDateTime releaseTime;

    LocalDateTime receiveTime;
}
