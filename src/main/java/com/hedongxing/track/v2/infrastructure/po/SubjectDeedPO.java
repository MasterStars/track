package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectDeedPO {

    String id;

    String subjectId;

    String deedId;

    //1，已提交；2，
    Integer status;

    String submitterId;

    //事迹提交时间
    LocalDateTime submitTime;

    //事迹完成时间
    LocalDateTime completeTime;

    //事迹确认时间
    LocalDateTime confirmTime;

    String attachments;

}
