package com.hedongxing.track.v2.management.application;

public interface RewardApplication {

    void addReward(String tenantId, String name, Double consumptionPoints);

    /**
     * 给特定成就设定奖励
     * @param tenantId 租户ID
     * @param achievementId 成就ID
     * @param rewardId 奖励ID
     */
    void setRewardOnAchievement(String tenantId, String achievementId, String rewardId);

    /**
     * 给成就积分设定奖励
     * @param tenantId
     * @param points
     * @param rewardId
     */
    void setRewardOnAchievementPoints(String tenantId, Integer points, String rewardId);

    /**
     * 给兑换积分设定奖励
     * @param tenantId
     * @param consumptionPoints
     * @param rewardId
     */
    void setExchangeReward(String tenantId, Double consumptionPoints, String rewardId);

    /**
     * 设置成就积分转换为消费积分比率
     * @param tenantId
     * @param rate 比率
     */
    void setAchievementPointsToConsumptionPointsRate(String tenantId, double rate);

}
