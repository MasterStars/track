package com.hedongxing.track.v2.management.application;

public interface AchievementKitApplication {

    /**
     * 创建成就套件
     * @param serialNumber 序列号
     * @param tenantId 租户ID
     * @param name 套件名称
     * @param description 套件描述
     * @param scope 作用域 1：当前租户，2：所有租户
     */
    void createAchievementKit(String serialNumber, String tenantId, String name, String description, Integer scope);
}
