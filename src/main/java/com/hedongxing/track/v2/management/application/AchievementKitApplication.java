package com.hedongxing.track.v2.management.application;

public interface AchievementKitApplication {

    /**
     * 创建成就套件(租户内可见)
     * @param tenantId
     * @param userId
     * @param serialNumber 序列号
     * @param name 套件名称
     * @param description 套件描述
     */
    void createAchievementKit(String tenantId, String userId, String serialNumber, String name, String description);

    /**
     * 创建官方套件（全平台可见）
     * @param serialNumber
     * @param name
     * @param description
     */
    void createOfficalAchievementKit(String serialNumber, String name, String description);
}
