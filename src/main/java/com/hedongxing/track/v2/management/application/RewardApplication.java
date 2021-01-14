package com.hedongxing.track.v2.management.application;

public interface RewardApplication {

    /**
     * 给特定成就设定奖励
     * @param id 奖励ID
     * @param tenantId 租户ID
     * @param achievementId 成就ID
     * @param rewardId 奖励ID
     */
    void setRewardOnAchievement(String id, String tenantId, String achievementId, String rewardId);

    /**
     * 给成就积分设定奖励
     * @param id
     * @param tenantId
     * @param points
     * @param rewardId
     */
    void setRewardOnAchievementPoints(String id, String tenantId, Integer points, String rewardId);

    /**
     * 设置成就积分转换为消费积分比率
     * @param tenantId
     * @param rate 比率
     */
    void setAchievementPointsToConsumptionPointsRate(String tenantId, double rate);

    /**
     * 添加奖励
     * @param id 奖励ID
     * @param tenantId 租户ID
     * @param rewardDescripton 奖励描述
     * @param consumptionPoints 对应消费积分
     */
    void addReward(String id, String tenantId, String rewardDescripton, Integer consumptionPoints);
}
