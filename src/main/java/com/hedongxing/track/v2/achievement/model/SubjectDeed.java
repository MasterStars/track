package com.hedongxing.track.v2.achievement.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectDeed {

    String id;

    String subjectId;

    String deedId;

    LocalDateTime completeTime;

}
