package com.hedongxing.track.v2.management.application;

public interface AchievementKitApplication {

    /**
     * 创建成就套件(租户内可见)
     * @param globalUserId
     * @param serialNumber
     * @param name
     * @param description
     */
    void createAchievementKit(String globalUserId, String serialNumber, String name, String description);

    /**
     * 创建官方套件（全平台可见）
     * @param serialNumber
     * @param name
     * @param description
     */
    void createOfficalAchievementKit(String globalUserId, String serialNumber, String name, String description);

    /**
     * 发布自己的套件
     * @param globalUserId
     * @param serialNumber
     */
    void publishAchievementKit(String globalUserId, String serialNumber);
}
