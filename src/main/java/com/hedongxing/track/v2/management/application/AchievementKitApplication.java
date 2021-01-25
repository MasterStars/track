package com.hedongxing.track.v2.management.application;

import com.hedongxing.track.v2.infrastructure.po.AchievementKitPO;

import java.util.List;

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
     * 查询用户名下拥有的成就套件
     * @param globalUserId
     * @return
     */
    List<AchievementKitPO> findGlobalUserOwnedKits(String globalUserId);

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
