package com.hedongxing.track.model;

import com.hedongxing.track.model.achievement.Achievement;

import java.util.Set;

public class AchievementCacheManager {

    private static Set<Achievement> achievements;

    public static Set<Achievement> getAllAchievements() {
        return achievements;
    }
}
