package com.hedongxing.track.v1.infrastructure.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveActionDTO {

    String actionDefinitionId;

    LocalDateTime actionTime;

    String arguments;
}
