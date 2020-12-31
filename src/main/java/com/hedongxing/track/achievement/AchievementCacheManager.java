package com.hedongxing.track.achievement;

import java.util.Set;

public class AchievementCacheManager {

    private static Set<Achievement> achievements;

    public static Set<Achievement> getAllAchievements() {
        return achievements;
    }
}
