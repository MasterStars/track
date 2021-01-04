package com.hedongxing.track.achievement.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccomplishedAchievement {

    private Achievement achievement;

    private LocalDateTime accomplishedTime;
}
