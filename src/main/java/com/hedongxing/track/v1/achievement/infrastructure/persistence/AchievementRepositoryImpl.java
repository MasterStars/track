package com.hedongxing.track.v1.achievement.infrastructure.persistence;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v1.infrastructure.mapper.AchievementMapper;
import com.hedongxing.track.v1.infrastructure.mapper.AchievementPropertyMapper;
import com.hedongxing.track.v1.infrastructure.po.AchievementPO;
import com.hedongxing.track.v1.infrastructure.po.AchievementPropertyPO;
import com.hedongxing.track.v1.achievement.model.Achievement;
import com.hedongxing.track.v1.achievement.model.AchievementRequirements;
import com.hedongxing.track.v1.achievement.model.Operator;
import com.hedongxing.track.v1.achievement.model.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class AchievementRepositoryImpl {

    private final AchievementMapper achievementMapper;

    private final AchievementPropertyMapper achievementPropertyMapper;

    private final PropertyRepositoryImpl propertyRepository;

    public Set<Achievement> allAchievements() {
        Set<Achievement> achievements = new HashSet<>();
        List<AchievementPO> achievementPOS = achievementMapper.selectList(Wrappers.emptyWrapper());
        for(AchievementPO achievementPO : achievementPOS) {
            List<AchievementPropertyPO> achievementPropertyPOS = achievementPropertyMapper.selectList(
                    Wrappers.<AchievementPropertyPO>lambdaQuery().eq(AchievementPropertyPO::getAchievementId, achievementPO.getId()));

            Map<Property, Long> propertyMap = new HashMap<>();
            for(AchievementPropertyPO achievementPropertyPO : achievementPropertyPOS) {
                propertyMap.put(propertyRepository.getPropertyById(achievementPropertyPO.getPropertyId()), achievementPropertyPO.getCriticalValue());
            }
            AchievementRequirements achievementRequirements = new AchievementRequirements(propertyMap, Operator.get(achievementPO.getOperator()));
            Achievement achievement = new Achievement(achievementPO.getName(), achievementPO.getScore(), achievementRequirements);

            achievements.add(achievement);
        }
        return achievements;
    }

    public Achievement getAchievementById(String id) {
        AchievementPO achievementPO = achievementMapper.selectById(id);
        List<AchievementPropertyPO> achievementPropertyPOS = achievementPropertyMapper.selectList(
                Wrappers.<AchievementPropertyPO>lambdaQuery().eq(AchievementPropertyPO::getAchievementId, achievementPO.getId()));

        Map<Property, Long> propertyMap = new HashMap<>();
        for(AchievementPropertyPO achievementPropertyPO : achievementPropertyPOS) {
            propertyMap.put(propertyRepository.getPropertyById(achievementPropertyPO.getPropertyId()), achievementPropertyPO.getCriticalValue());
        }
        AchievementRequirements achievementRequirements = new AchievementRequirements(propertyMap, Operator.get(achievementPO.getOperator()));
        return new Achievement(achievementPO.getName(), achievementPO.getScore(), achievementRequirements);
    }
}
