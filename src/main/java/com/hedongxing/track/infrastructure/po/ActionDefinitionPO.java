package com.hedongxing.track.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActionDefinitionPO {

    String id;

    String actionWord;

    String name;

    String pattern;

    String argumentKeys;
}
