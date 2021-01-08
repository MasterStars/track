package com.hedongxing.track.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActionPO {

    String id;

    String name;

    String actionDetail;

}
