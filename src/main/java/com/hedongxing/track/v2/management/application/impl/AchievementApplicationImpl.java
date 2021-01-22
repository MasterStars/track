package com.hedongxing.track.v2.management.application.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v2.infrastructure.mapper.AchievementDeedMapper;
import com.hedongxing.track.v2.infrastructure.mapper.AchievementMapper;
import com.hedongxing.track.v2.infrastructure.po.AchievementDeedPO;
import com.hedongxing.track.v2.infrastructure.po.AchievementPO;
import com.hedongxing.track.v2.management.application.AchievementApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AchievementApplicationImpl implements AchievementApplication {

    private final AchievementMapper achievementMapper;

    private final AchievementDeedMapper achievementDeedMapper;

    @Override
    public void addAchievement(String kitSerialNumber, String categoryId, String name, String description, Integer points, Integer minAge, Integer maxAge, Integer daysLimitToComplete, Integer sexLimit, Map<String, Integer> deedRequirments) {
        AchievementPO achievementPO = new AchievementPO();
        achievementPO.setId(UUID.randomUUID().toString());
        achievementPO.setKitSerialNumber(kitSerialNumber);
        achievementPO.setCategoryId(categoryId);
        achievementPO.setName(name);
        achievementPO.setDescription(description);
        achievementPO.setPoints(points);
        achievementPO.setMinAge(minAge);
        achievementPO.setMaxAge(maxAge);
        achievementPO.setDaysLimitToComplete(daysLimitToComplete);
        achievementPO.setSexLimit(sexLimit);
        achievementMapper.insert(achievementPO);

        for(String deedId : deedRequirments.keySet()) {
            AchievementDeedPO achievementDeedPO = new AchievementDeedPO();
            achievementDeedPO.setId(UUID.randomUUID().toString());
            achievementDeedPO.setDeedId(deedId);
            achievementDeedPO.setAchievementId(achievementPO.getId());
            achievementDeedPO.setTimes(deedRequirments.get(deedId));
            achievementDeedMapper.insert(achievementDeedPO);
        }
    }

    @Override
    public void editAchievementRequirements(String achievementId, Map<String, Integer> deedRequirments) {
        achievementDeedMapper.delete(
                Wrappers.<AchievementDeedPO>lambdaQuery().eq(AchievementDeedPO::getAchievementId, achievementId));

        for(String deedId : deedRequirments.keySet()) {
            AchievementDeedPO achievementDeedPO = new AchievementDeedPO();
            achievementDeedPO.setId(UUID.randomUUID().toString());
            achievementDeedPO.setDeedId(deedId);
            achievementDeedPO.setAchievementId(achievementId);
            achievementDeedPO.setTimes(deedRequirments.get(deedId));
            achievementDeedMapper.insert(achievementDeedPO);
        }
    }
}
