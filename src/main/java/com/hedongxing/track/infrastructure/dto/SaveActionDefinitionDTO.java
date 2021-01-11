package com.hedongxing.track.infrastructure.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveActionDefinitionDTO {

    String actionWord;

    String name;

    String pattern;

    String argumentKeys;

    List<String> propertyIds;
}
