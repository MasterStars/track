package com.hedongxing.track.v2.reward.application.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v2.infrastructure.mapper.AchievementPointsRewardMapper;
import com.hedongxing.track.v2.infrastructure.mapper.SubjectAchievementPointsRewardMapper;
import com.hedongxing.track.v2.infrastructure.mapper.SubjectMapper;
import com.hedongxing.track.v2.infrastructure.po.AchievementPointsRewardPO;
import com.hedongxing.track.v2.infrastructure.po.SubjectAchievementPointsRewardPO;
import com.hedongxing.track.v2.infrastructure.po.SubjectPO;
import com.hedongxing.track.v2.reward.application.RewardApplication;
import com.hedongxing.track.v2.reward.model.AchievementPointsReward;
import com.hedongxing.track.v2.reward.model.ExchangeReward;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RewardApplicationImpl implements RewardApplication {

    private final SubjectMapper subjectMapper;

    private final AchievementPointsRewardMapper achievementPointsRewardMapper;

    private final SubjectAchievementPointsRewardMapper subjectAchievementPointsRewardMapper;

    @Override
    public void applyAchievementPointsReward(String subjectId, String achievementPointsRewardId, LocalDateTime applyTime) {
        SubjectPO subjectPO = subjectMapper.selectById(subjectId);
        AchievementPointsRewardPO achievementPointsRewardPO =
                achievementPointsRewardMapper.selectById(achievementPointsRewardId);

        SubjectAchievementPointsRewardPO subjectAchievementPointsRewardPO =
                subjectAchievementPointsRewardMapper.selectOne(Wrappers.<SubjectAchievementPointsRewardPO>lambdaQuery()
                .eq(SubjectAchievementPointsRewardPO::getSubjectId, subjectId)
                .eq(SubjectAchievementPointsRewardPO::getAchievementPointsRewardId, achievementPointsRewardId));
        if(subjectAchievementPointsRewardPO != null) {
            throw new RuntimeException("已经领取过" + achievementPointsRewardPO.getAchievementPoints() + "奖励");
        }

        if(subjectPO.getAchievementPoints() < achievementPointsRewardPO.getAchievementPoints()) {
            throw new RuntimeException("成就积分不足以领取奖励!");
        }

        SubjectAchievementPointsRewardPO newSubjectAchievementPointsRewardPO =
                new SubjectAchievementPointsRewardPO();
        newSubjectAchievementPointsRewardPO.setId(UUID.randomUUID().toString());
        newSubjectAchievementPointsRewardPO.setAchievementPointsRewardId(achievementPointsRewardId);
        newSubjectAchievementPointsRewardPO.setTenantId(subjectPO.getTenantId());
        newSubjectAchievementPointsRewardPO.setSubjectId(subjectId);
        newSubjectAchievementPointsRewardPO.setApplyTime(applyTime);
        newSubjectAchievementPointsRewardPO.setStatus(1);
        subjectAchievementPointsRewardMapper.insert(newSubjectAchievementPointsRewardPO);
    }

    @Override
    public void receiveAchievementPointsReward(String subjectAchievementPointsRewardId, LocalDateTime receiveTime) {
        SubjectAchievementPointsRewardPO subjectAchievementPointsRewardPO =
                subjectAchievementPointsRewardMapper.selectById(subjectAchievementPointsRewardId);
        if(subjectAchievementPointsRewardPO.getStatus() != 1) {
            throw new RuntimeException("积分奖励状态不对，不能接收");
        }
        subjectAchievementPointsRewardPO.setStatus(2);
        subjectAchievementPointsRewardPO.setReceiveTime(receiveTime);
        subjectAchievementPointsRewardMapper.updateById(subjectAchievementPointsRewardPO);
    }

    @Override
    public void releaseAchievementPointsReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime) {

    }

    @Override
    public void applyExchangeReward(String subjectId, String rewardId, LocalDateTime applyTime) {

    }

    @Override
    public void receiveExchangeReward(String subjectId, String rewardId, LocalDateTime receiveTime) {

    }

    @Override
    public void releaseExchangeReward(String rewardReleaserId, String subjectId, String rewardId, LocalDateTime releaseTime) {

    }

    @Override
    public AchievementPointsReward getAchievementPointsReward(String tenantId, Integer achievementPoints) {
        return null;
    }

    @Override
    public ExchangeReward getExchangeRewardById(String rewardId) {
        return null;
    }
}
