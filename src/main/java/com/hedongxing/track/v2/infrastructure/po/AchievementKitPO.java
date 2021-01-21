package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AchievementKitPO {

    String kitSerialNumber;

    String name;

    String description;

    //1,官方;2,自定义
    Integer type;

    Boolean isPublished;
}
