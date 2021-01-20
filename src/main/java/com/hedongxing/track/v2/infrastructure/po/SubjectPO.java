package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectPO {

    String id;

    String tenantId;

    String userId;

    String nickname;

    //家庭内称谓
    String title;

    Integer achievementPoints;

    Double consumptionPoints;


}
