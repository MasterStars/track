package com.hedongxing.track.v2.management.infrastructure.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EditDeedDTO {

    String categoryId;

    String name;

    String description;
}
