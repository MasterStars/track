package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectAchievementPointsRewardPO {

    String id;

    String subjectId;

    String achievementPointsRewardId;

    LocalDateTime applyTime;

    LocalDateTime releaseTime;

    LocalDateTime receiveTime;
}
