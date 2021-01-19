package com.hedongxing.track.v2.deed.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SubjectDeed {

    public static final Integer PLACED = 1;

    public static final Integer VALID = 2;

    public static final Integer INVALID = 3;

    String id;

    String subjectId;

    String deedId;

    //1:已提交，2；已确认有效，3：已确认无效
    Integer status;

    LocalDateTime completeTime;

    LocalDateTime submitTime;

    String attachments;
}
