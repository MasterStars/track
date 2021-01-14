package com.hedongxing.track.v2.reward.application;

import java.time.LocalDateTime;

public interface RewardApplication {

    /**
     * 主角申请领取成就积分奖励
     * @param subjectId 主角ID
     * @param points 哪个分段的奖励
     * @param applyTime 申请时间
     */
    void applyAchievementPointsReward(String subjectId, Integer points, LocalDateTime applyTime);

    /**
     * 主角领取成就积分奖励
     * @param subjectId 主角ID
     * @param points 哪个分段的奖励
     * @param receiveTime 领取时间
     */
    void receiveAchievementPointsReward(String subjectId, Integer points, LocalDateTime receiveTime);

    /**
     * 主角申请用消费积分兑换奖励
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     */
    void applyExchangeConsumptionRewards(String subjectId, String rewardId);

    void receiveExchangeConsumptionRewards(String subjectId, String rewardId);
}
