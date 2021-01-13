package com.hedongxing.track.property.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AccomplishedAchievement {

    private Achievement achievement;

    private LocalDateTime accomplishedTime;
}
