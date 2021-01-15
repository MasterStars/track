package com.hedongxing.track.v2.achievement.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject {

    String id;

    Integer achievementPoints;

    List<SubjectAchievement> subjectAchievements;

    Double consumptionPoints;
}
