package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GlobalUserAchievementKitPO {

    String id;

    String globalUserId;

    String kitSerialNumber;
}
