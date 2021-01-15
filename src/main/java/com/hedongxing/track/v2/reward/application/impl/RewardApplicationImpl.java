package com.hedongxing.track.v2.reward.application.impl;

import com.hedongxing.track.v2.infrastructure.support.EventPublisher;
import com.hedongxing.track.v2.reward.application.RewardApplication;
import com.hedongxing.track.v2.reward.application.SubjectApplication;
import com.hedongxing.track.v2.reward.application.SubjectRewardApplication;
import com.hedongxing.track.v2.reward.model.AchievementReward;
import com.hedongxing.track.v2.reward.model.ExchangeReward;
import com.hedongxing.track.v2.reward.model.Subject;
import com.hedongxing.track.v2.reward.model.event.AchievementRewardApplied;
import com.hedongxing.track.v2.reward.model.event.ExchangeRewardApplied;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static com.hedongxing.track.v2.infrastructure.support.EventPublisher.PUBLISH;

@RequiredArgsConstructor
public class RewardApplicationImpl implements RewardApplication {

    private final SubjectRewardApplication subjectRewardApplication;

    private final SubjectApplication subjectApplication;

    @Override
    public void applyAchievementReward(String subjectId, String rewardId, LocalDateTime applyTime) {
        if(!subjectRewardApplication.hasReceivedAchievementReward(subjectId, rewardId)){
            AchievementReward achievementReward = getAchievementRewardById(rewardId);
            Subject subject = subjectApplication.getSubjectById(subjectId);
            if(subject.getAchievementPoints() > achievementReward.getAchievementPoints()) {
                PUBLISH(new AchievementRewardApplied(achievementReward));
            }
        }


    }

    @Override
    public void receiveAchievementReward(String subjectId, String rewardId, LocalDateTime receiveTime) {

    }

    @Override
    public void releaseAchievementReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime) {

    }

    @Override
    public void applyExchangeReward(String subjectId, String rewardId, LocalDateTime applyTime) {
        ExchangeReward exchangeReward = getExchangeRewardById(rewardId);
        Subject subject = subjectApplication.getSubjectById(subjectId);
        if(subject.getConsumptionPoints() > exchangeReward.getConsumptionPoints()) {
            PUBLISH(new ExchangeRewardApplied(exchangeReward));
        }
    }

    @Override
    public void receiveExchangeReward(String subjectId, String rewardId, LocalDateTime receiveTime) {

    }

    @Override
    public void releaseExchangeReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime) {

    }


    @Override
    public AchievementReward getAchievementRewardById(String rewardId) {
        return null;
    }

    @Override
    public ExchangeReward getExchangeRewardById(String rewardId) {
        return null;
    }
}
