package com.hedongxing.track.achievement.model;

import com.hedongxing.track.achievement.infrastructure.persistence.AchievementRepositoryImpl;
import com.hedongxing.track.infrastructure.util.SpringBeanUtil;

import java.util.Set;

public class AchievementRepository {

    public static Set<Achievement> allAchievements() {
        return SpringBeanUtil.getBean(AchievementRepositoryImpl.class).allAchievements();
    }
}
