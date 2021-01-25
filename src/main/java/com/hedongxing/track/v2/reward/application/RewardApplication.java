package com.hedongxing.track.v2.reward.application;

import com.hedongxing.track.v2.reward.model.AchievementPointsReward;
import com.hedongxing.track.v2.reward.model.ExchangeReward;

import java.time.LocalDateTime;

public interface RewardApplication {

    /**
     * 主角申请领取成就分数奖励
     * @param subjectId 主角ID
     * @param achievementPoints 奖励分数
     * @param applyTime 申请时间
     */
    void applyAchievementPointsReward(String subjectId, Integer achievementPoints, LocalDateTime applyTime);

    /**
     * 主角领取成就积分奖励
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     * @param receiveTime 领取时间
     */
    void receiveAchievementPointsReward(String subjectId, String rewardId, LocalDateTime receiveTime);

    /**
     * 下发成就奖励
     * @param rewardReleaserId 下发者ID
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     * @param releaseTime 下发时间
     */
    void releaseAchievementPointsReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime);

    /**
     * 主角申请兑换奖励
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     */
    void applyExchangeReward(String subjectId, String rewardId, LocalDateTime applyTime);

    /**
     * 主角接收兑换奖励
     * @param subjectId
     * @param rewardId
     * @param receiveTime
     */
    void receiveExchangeReward(String subjectId, String rewardId, LocalDateTime receiveTime);

    /**
     * 下发者下发兑换奖励
     * @param rewardReleaserId
     * @param subjectId
     * @param rewardId
     * @param releaseTime
     */
    void releaseExchangeReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime);

    AchievementPointsReward getAchievementPointsReward(String tenantId, Integer achievementPoints);

    ExchangeReward getExchangeRewardById(String rewardId);
}
