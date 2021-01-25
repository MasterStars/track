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
public class  SubjectDeed {

    //已提交
    public static final Integer PLACED = 1;

    //已确认有效
    public static final Integer VALID = 2;

    //已确认无效
    public static final Integer INVALID = 3;

    String id;

    String subjectId;

    String deedId;

    String submitterId;

    String attachments;

    Integer status;
}
