package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectAchievementPointsRewardPO {

    String id;

    String tenantId;

    String subjectId;

    String achievementPointsRewardId;

    //1,已申请;2，已下发；3，已接收
    Integer status;

    LocalDateTime applyTime;

    LocalDateTime releaseTime;

    LocalDateTime receiveTime;
}
