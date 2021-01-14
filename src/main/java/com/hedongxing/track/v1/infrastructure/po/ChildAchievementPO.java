package com.hedongxing.track.v1.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("child_achievement")
public class ChildAchievementPO {

    String id;

    String childId;

    String achievementId;

    LocalDateTime accomplishedTime;
}
