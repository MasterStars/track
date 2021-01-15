package com.hedongxing.track.v2.achievement.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Achievement {

    String id;

    String categoryId;

    Map<String, Integer> deedsRequirment;

    String timeLimit;

    Integer points;
}
