package com.hedongxing.track.achievement.infrastructure.persistence;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.achievement.model.AccomplishedAchievement;
import com.hedongxing.track.achievement.model.Achievement;
import com.hedongxing.track.infrastructure.mapper.AchievementMapper;
import com.hedongxing.track.infrastructure.mapper.ChildAchievementMapper;
import com.hedongxing.track.infrastructure.po.AchievementPO;
import com.hedongxing.track.infrastructure.po.ChildAchievementPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AccomplishedAchievementRepositoryImpl {

    private final ChildAchievementMapper childAchievementMapper;

    private final AchievementMapper achievementMapper;

    public void addAccomplishedAchievement(String childId, AccomplishedAchievement accomplishedAchievement) {
        Achievement achievement = accomplishedAchievement.getAchievement();
        AchievementPO achievementPO = achievementMapper.selectOne(
                Wrappers.<AchievementPO>lambdaQuery().eq(AchievementPO::getName, achievement.getName()));

        ChildAchievementPO childAchievementPO = new ChildAchievementPO();
        childAchievementPO.setId(UUID.randomUUID().toString());
        childAchievementPO.setChildId(childId);
        childAchievementPO.setAchievementId(achievementPO.getId());
        childAchievementPO.setAccomplishedTime(accomplishedAchievement.getAccomplishedTime());

        childAchievementMapper.insert(childAchievementPO);
    }
}
