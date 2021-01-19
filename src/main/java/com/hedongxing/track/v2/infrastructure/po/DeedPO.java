package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeedPO {

    String id;

    String kitSerialNumber;

    String categoryId;

    String name;

    String description;
}
