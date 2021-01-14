package com.hedongxing.track.v1.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("achievement")
public class AchievementPO {

    String id;

    String name;

    Integer score;

    String operator;
}
