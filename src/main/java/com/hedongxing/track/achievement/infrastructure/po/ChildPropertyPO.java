package com.hedongxing.track.achievement.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildPropertyPO {

    String id;

    String childId;

    String propertyId;

    Long value;
}
