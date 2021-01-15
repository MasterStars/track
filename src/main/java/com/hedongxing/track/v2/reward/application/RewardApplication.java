package com.hedongxing.track.v2.reward.application;

import com.hedongxing.track.v2.reward.model.AchievementReward;
import com.hedongxing.track.v2.reward.model.ExchangeReward;

import java.time.LocalDateTime;

public interface RewardApplication {

    /**
     * 主角申请领取成就奖励
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     * @param applyTime 申请时间
     */
    void applyAchievementReward(String subjectId, String rewardId, LocalDateTime applyTime);

    /**
     * 主角领取成就积分奖励
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     * @param receiveTime 领取时间
     */
    void receiveAchievementReward(String subjectId, String rewardId, LocalDateTime receiveTime);

    /**
     * 下发成就奖励
     * @param rewardReleaserId 下发者ID
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     * @param releaseTime 下发时间
     */
    void releaseAchievementReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime);

    /**
     * 主角申请兑换奖励
     * @param subjectId 主角ID
     * @param rewardId 奖励ID
     */
    void applyExchangeReward(String subjectId, String rewardId, LocalDateTime applyTime);

    void receiveExchangeReward(String subjectId, String rewardId, LocalDateTime receiveTime);

    void releaseExchangeReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime);

    AchievementReward getAchievementRewardById(String rewardId);

    ExchangeReward getExchangeRewardById(String rewardId);
}
