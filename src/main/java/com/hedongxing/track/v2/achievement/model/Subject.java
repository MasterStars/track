package com.hedongxing.track.v2.achievement.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject {

    String id;

    Integer achievementPoints;

    Double consumptionPoints;

}
