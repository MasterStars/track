package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReleaseRecordPO {

    String id;

    String subjectId;

    String releaserId;

    String rewardId;

    LocalDateTime releaseTime;
}
