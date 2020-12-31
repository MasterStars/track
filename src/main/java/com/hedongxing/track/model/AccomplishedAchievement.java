package com.hedongxing.track.model;

import com.hedongxing.track.model.achievement.Achievement;
import lombok.AllArgsConstructor;
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
