package com.hedongxing.track.v2.reward.application.impl;

import com.hedongxing.track.v2.reward.application.RewardApplication;
import com.hedongxing.track.v2.reward.application.SubjectApplication;
import com.hedongxing.track.v2.reward.application.SubjectRewardApplication;
import com.hedongxing.track.v2.reward.model.AchievementPointsReward;
import com.hedongxing.track.v2.reward.model.ExchangeReward;
import com.hedongxing.track.v2.reward.model.Subject;
import com.hedongxing.track.v2.reward.model.event.AchievementRewardApplied;
import com.hedongxing.track.v2.reward.model.event.ExchangeRewardApplied;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static com.hedongxing.track.v2.infrastructure.support.EventBus.PublishEvent;


@RequiredArgsConstructor
public class RewardApplicationImpl implements RewardApplication {

    private final SubjectRewardApplication subjectRewardApplication;

    private final SubjectApplication subjectApplication;

    @Override
    public void applyAchievementPointsReward(String subjectId, String rewardId, LocalDateTime applyTime) {
        if(!subjectRewardApplication.hasReceivedAchievementReward(subjectId, rewardId)){
            AchievementPointsReward achievementPointsReward = getAchievementPointsRewardById(rewardId);
            Subject subject = subjectApplication.getSubjectById(subjectId);
            if(subject.getAchievementPoints() > achievementPointsReward.getAchievementPoints()) {
                PublishEvent(new AchievementRewardApplied(this, achievementPointsReward, applyTime));
            }
        }


    }

    @Override
    public void receiveAchievementPointsReward(String subjectId, String rewardId, LocalDateTime receiveTime) {


    }

    @Override
    public void releaseAchievementPointsReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime) {

    }

    @Override
    public void applyExchangeReward(String subjectId, String rewardId, LocalDateTime applyTime) {
        ExchangeReward exchangeReward = getExchangeRewardById(rewardId);
        Subject subject = subjectApplication.getSubjectById(subjectId);
        if(subject.getConsumptionPoints() > exchangeReward.getConsumptionPoints()) {
            PublishEvent(new ExchangeRewardApplied(this, exchangeReward, applyTime));
        }
    }

    @Override
    public void receiveExchangeReward(String subjectId, String rewardId, LocalDateTime receiveTime) {

    }

    @Override
    public void releaseExchangeReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime) {

    }


    @Override
    public AchievementPointsReward getAchievementPointsRewardById(String rewardId) {
        return null;
    }

    @Override
    public ExchangeReward getExchangeRewardById(String rewardId) {
        return null;
    }
}
