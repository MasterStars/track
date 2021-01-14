package com.hedongxing.track.v1.infrastructure.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SavePropertyDTO {

    String name;

    String unit;
}
