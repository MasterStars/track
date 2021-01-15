package com.hedongxing.track.v2.achievement.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectAchievement {

    String id;

    String subjectId;

    String achievementId;

    Map<String, Integer> progress;

    Boolean isAccomplished;

    LocalDateTime accomplishTime;
}
