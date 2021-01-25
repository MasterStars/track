package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectAchievementRewardPO {

    String id;

    String tenantId;

    String subjectId;

    String achievementRewardId;

    LocalDateTime applyTime;

    LocalDateTime receiveTime;
}
