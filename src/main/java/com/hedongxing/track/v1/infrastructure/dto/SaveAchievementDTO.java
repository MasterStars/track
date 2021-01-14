package com.hedongxing.track.v1.infrastructure.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveAchievementDTO {

    String name;

    Integer score;

    String operator;

    Map<String, Long> properties;
}
