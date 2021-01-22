package com.hedongxing.track.v2.management.application.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v2.infrastructure.mapper.*;
import com.hedongxing.track.v2.infrastructure.po.*;
import com.hedongxing.track.v2.management.application.RewardApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RewardApplicationImpl implements RewardApplication {

    private final RewardMapper rewardMapper;

    private final AchievementRewardMapper achievementRewardMapper;

    private final AchievementPointsRewardMapper achievementPointsRewardMapper;

    private final ExchangeRewardMapper exchangeRewardMapper;

    private final AchievementPointsConsumptionPointsMapper achievementPointsConsumptionPointsMapper;

    @Override
    public void addReward(String tenantId, String name, Double consumptionPoints) {
        RewardPO rewardPO = new RewardPO();
        rewardPO.setId(UUID.randomUUID().toString());
        rewardPO.setTenantId(tenantId);
        rewardPO.setName(name);
        rewardPO.setConsumptionPoints(consumptionPoints);
        rewardMapper.insert(rewardPO);
    }

    @Override
    public void setRewardOnAchievement(String tenantId, String achievementId, String rewardId) {
        AchievementRewardPO achievementRewardPO = achievementRewardMapper.selectOne(
                Wrappers.<AchievementRewardPO>lambdaQuery().eq(AchievementRewardPO::getTenantId, tenantId)
                .eq(AchievementRewardPO::getAchievementId, achievementId));
        if(achievementRewardPO == null) {
            achievementRewardPO = new AchievementRewardPO();
            achievementRewardPO.setId(UUID.randomUUID().toString());
            achievementRewardPO.setTenantId(tenantId);
            achievementRewardPO.setAchievementId(achievementId);
            achievementRewardPO.setRewardId(rewardId);
            achievementRewardMapper.insert(achievementRewardPO);
        }else{
            achievementRewardPO.setRewardId(rewardId);
            achievementRewardMapper.updateById(achievementRewardPO);
        }
    }

    @Override
    public void setRewardOnAchievementPoints(String tenantId, Integer points, String rewardId) {
        AchievementPointsRewardPO achievementPointsRewardPO = achievementPointsRewardMapper.selectOne(
                Wrappers.<AchievementPointsRewardPO>lambdaQuery().eq(AchievementPointsRewardPO::getTenantId, tenantId)
                .eq(AchievementPointsRewardPO::getAchievementPoints, points));
        if(achievementPointsRewardPO == null) {
            achievementPointsRewardPO = new AchievementPointsRewardPO();
            achievementPointsRewardPO.setId(UUID.randomUUID().toString());
            achievementPointsRewardPO.setTenantId(tenantId);
            achievementPointsRewardPO.setAchievementPoints(points);
            achievementPointsRewardPO.setRewardId(rewardId);
            achievementPointsRewardMapper.insert(achievementPointsRewardPO);
        }else{
            achievementPointsRewardPO.setRewardId(rewardId);
            achievementPointsRewardMapper.updateById(achievementPointsRewardPO);
        }
    }

    @Override
    public void setExchangeReward(String tenantId, Double consumptionPoints, String rewardId) {
        ExchangeRewardPO exchangeRewardPO = exchangeRewardMapper.selectOne(
                Wrappers.<ExchangeRewardPO>lambdaQuery().eq(ExchangeRewardPO::getTenantId, tenantId)
                .eq(ExchangeRewardPO::getConsumptionPoints, consumptionPoints));
        if(exchangeRewardPO == null) {
            exchangeRewardPO = new ExchangeRewardPO();
            exchangeRewardPO.setId(UUID.randomUUID().toString());
            exchangeRewardPO.setTenantId(tenantId);
            exchangeRewardPO.setConsumptionPoints(consumptionPoints);
            exchangeRewardPO.setRewardId(rewardId);
            exchangeRewardMapper.insert(exchangeRewardPO);
        }else{
            exchangeRewardPO.setRewardId(rewardId);
            exchangeRewardMapper.updateById(exchangeRewardPO);
        }
    }

    @Override
    public void setAchievementPointsToConsumptionPointsRate(String tenantId, double rate) {
        achievementPointsConsumptionPointsMapper.delete(
                Wrappers.<AchievementPointsConsumptionPointsRatePO>lambdaQuery().eq(AchievementPointsConsumptionPointsRatePO::getTenantId, tenantId));

        AchievementPointsConsumptionPointsRatePO achievementPointsConsumptionPointsRatePO = new AchievementPointsConsumptionPointsRatePO();
        achievementPointsConsumptionPointsRatePO.setId(UUID.randomUUID().toString());
        achievementPointsConsumptionPointsRatePO.setTenantId(tenantId);
        achievementPointsConsumptionPointsRatePO.setRate(rate);
        achievementPointsConsumptionPointsMapper.insert(achievementPointsConsumptionPointsRatePO);
    }
}
