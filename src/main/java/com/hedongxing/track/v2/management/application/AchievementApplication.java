package com.hedongxing.track.v2.management.application;

import java.util.Map;

public interface AchievementApplication {

    /**
     * 添加成就
     * @param id 成就ID
     * @param kitSerialNumber 所属套件序列号
     * @param categoryId 成就种类ID
     * @param name 成就名称
     * @param description 成就描述
     * @param deedsRequirment 成就达成需要的事迹map，键是事迹ID，值是达成次数
     * @param timeLimit 成就的时间限制
     * @param points 成就分
     */
    void addAchievement(String id, String kitSerialNumber, String categoryId, String name, String description, Map<String, Integer> deedsRequirment, String timeLimit, Integer points);

    /**
     * 编辑成就
     * @param id
     * @param kitSerialNumber 所属套件序列号
     * @param categoryId
     * @param name
     * @param description
     * @param deedsRequirment
     * @param timeLimit
     * @param points
     */
    void editAchievement(String id, String kitSerialNumber, String categoryId, String name, String description, Map<String, Integer> deedsRequirment, String timeLimit, Integer points);
}
