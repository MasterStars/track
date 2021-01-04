package com.hedongxing.track.achievement.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AchievementRepository {

    public static Set<Achievement> allAchievements() {
        Set<Achievement> achievements = new HashSet<>();

        Map<String, Object> map = new HashMap<>();
        map.put("single-sleep-hours", 4);
        Achievement sleeper = new Achievement("睡觉爱好者", 10, map);
        achievements.add(sleeper);
        map.clear();

        map.put("total-sleep-hours", 100);
        Achievement sleeplv1 = new Achievement("睡者", 10, map);
        achievements.add(sleeplv1);
        map.put("total-sleep-hours", 200);
        Achievement sleeplv2 = new Achievement("睡师", 10, map);
        achievements.add(sleeplv2);
        map.put("total-sleep-hours", 300);
        Achievement sleeplv3 = new Achievement("大睡师", 10, map);
        achievements.add(sleeplv3);
        map.put("total-sleep-hours", 500);
        Achievement sleeplv4 = new Achievement("睡灵", 10, map);
        achievements.add(sleeplv4);
        map.put("total-sleep-hours", 7000);
        Achievement sleeplv5 = new Achievement("睡王", 10, map);
        achievements.add(sleeplv5);
        map.put("total-sleep-hours", 1000);
        Achievement sleeplv6 = new Achievement("睡黄", 10, map);
        achievements.add(sleeplv6);
        map.put("total-sleep-hours", 1300);
        Achievement sleeplv7 = new Achievement("睡宗", 10, map);
        achievements.add(sleeplv7);
        map.put("total-sleep-hours", 1600);
        Achievement sleeplv8 = new Achievement("睡尊", 10, map);
        achievements.add(sleeplv8);
        map.put("total-sleep-hours", 2000);
        Achievement sleeplv9 = new Achievement("睡圣", 10, map);
        achievements.add(sleeplv9);
        map.put("total-sleep-hours", 3000);
        Achievement sleeplv10 = new Achievement("睡帝", 10, map);
        achievements.add(sleeplv10);

        return achievements;

    }
}
