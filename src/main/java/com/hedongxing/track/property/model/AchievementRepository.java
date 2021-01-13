package com.hedongxing.track.property.model;

import com.hedongxing.track.property.infrastructure.persistence.AchievementRepositoryImpl;
import com.hedongxing.track.infrastructure.util.SpringBeanUtil;

import java.util.Collections;
import java.util.Set;

public class AchievementRepository {

    private static Set<Achievement> allAchievements;

    public AchievementRepository() {
        allAchievements = Collections.unmodifiableSet(SpringBeanUtil.getBean(AchievementRepositoryImpl.class).allAchievements());
    }

    public static Set<Achievement> allAchievements() {
        return allAchievements;
    }
}
