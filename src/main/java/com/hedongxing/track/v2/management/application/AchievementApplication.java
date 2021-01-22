package com.hedongxing.track.v2.management.application;

import java.util.Map;

public interface AchievementApplication {

    /**
     * 添加成就
     * @param kitSerialNumber 所属套件序列号
     * @param categoryId 成就种类ID
     * @param name 成就名称
     * @param description 成就描述
     * @param deedRequirments 成就达成需要的事迹map，键是事迹ID，值是达成次数
     * @param points 成就分
     */
    void addAchievement(String kitSerialNumber, String categoryId, String name,
                        String description, Integer points, Integer minAge,
                        Integer maxAge, Integer daysLimitToComplete, Integer sexLimit,
                        Map<String, Integer> deedRequirments);

    void editAchievementRequirements(String achievementId, Map<String, Integer> deedRequirments);
}
