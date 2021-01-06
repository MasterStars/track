package com.hedongxing.track.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildAchievementPO {

    String id;

    String childId;

    String achievementId;

    LocalDateTime accomplishedTime;
}
