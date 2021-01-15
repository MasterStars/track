package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectDeedPO {

    String id;

    String subjectId;

    String deedId;

    Integer status;

    String rewardReleaserId;


}
