package com.hedongxing.track.achievement.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AchievementRepository {

    public static Set<Achievement> allAchievements() {
        Set<Achievement> achievements = new HashSet<>();

        Map<Property, Long> map = new HashMap<>();
        map.put(PropertyRepository.getProperty("单次睡眠时长"), 4 * 3600L);
        Achievement sleeper = new Achievement("睡觉爱好者", 10, new AchievementRequirements(map));
        achievements.add(sleeper);
        map.clear();

        map.put(PropertyRepository.getProperty("睡眠总时长"), 100L);
        Achievement sleeplv1 = new Achievement("睡者", 10, new AchievementRequirements(map));
        achievements.add(sleeplv1);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 200L);
        Achievement sleeplv2 = new Achievement("睡师", 10, new AchievementRequirements(map));
        achievements.add(sleeplv2);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 300L);
        Achievement sleeplv3 = new Achievement("大睡师", 10, new AchievementRequirements(map));
        achievements.add(sleeplv3);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 500L);
        Achievement sleeplv4 = new Achievement("睡灵", 10, new AchievementRequirements(map));
        achievements.add(sleeplv4);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 7000L);
        Achievement sleeplv5 = new Achievement("睡王", 10, new AchievementRequirements(map));
        achievements.add(sleeplv5);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 1000L);
        Achievement sleeplv6 = new Achievement("睡皇", 10, new AchievementRequirements(map));
        achievements.add(sleeplv6);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 1300L);
        Achievement sleeplv7 = new Achievement("睡宗", 10, new AchievementRequirements(map));
        achievements.add(sleeplv7);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 1600L);
        Achievement sleeplv8 = new Achievement("睡尊", 10, new AchievementRequirements(map));
        achievements.add(sleeplv8);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 2000L);
        Achievement sleeplv9 = new Achievement("睡圣", 10, new AchievementRequirements(map));
        achievements.add(sleeplv9);
        map.put(PropertyRepository.getProperty("睡眠总时长"), 3000L);
        Achievement sleeplv10 = new Achievement("睡帝", 10, new AchievementRequirements(map));
        achievements.add(sleeplv10);

        return achievements;

    }
}
