package com.hedongxing.track.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActionPropertyPO {

    String id;

    String actionId;

    String propertyId;

    Long value;
}
