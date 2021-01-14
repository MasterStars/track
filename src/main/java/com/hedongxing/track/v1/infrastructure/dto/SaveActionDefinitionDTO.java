package com.hedongxing.track.v1.infrastructure.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveActionDefinitionDTO {

    String actionWord;

    String name;

    String pattern;

    String argumentKeys;

    Map<String, Integer> properties;
}
