package com.hedongxing.track.achievement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AccomplishedAchievement {

    private Achievement achievement;

    private LocalDateTime accomplishedTime;

    public Integer getPoints() {
        return achievement.getScore();
    }
}
