package com.hedongxing.track.v1.achievement.infrastructure.persistence;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v1.achievement.model.AccomplishedAchievement;
import com.hedongxing.track.v1.achievement.model.Child;
import com.hedongxing.track.v1.achievement.model.ChildProperties;
import com.hedongxing.track.v1.achievement.model.Property;
import com.hedongxing.track.v1.infrastructure.mapper.ChildAchievementMapper;
import com.hedongxing.track.v1.infrastructure.mapper.ChildMapper;
import com.hedongxing.track.v1.infrastructure.mapper.ChildPropertyMapper;
import com.hedongxing.track.v1.infrastructure.po.ChildAchievementPO;
import com.hedongxing.track.v1.infrastructure.po.ChildPO;
import com.hedongxing.track.v1.infrastructure.po.ChildPropertyPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ChildRepositoryImpl {

    private final ChildMapper childMapper;

    private final ChildPropertyMapper childPropertyMapper;

    private final ChildAchievementMapper childAchievementMapper;

    private final PropertyRepositoryImpl propertyRepository;

    private final AchievementRepositoryImpl achievementRepository;

    private final ActionRepositoryImpl actionRepository;

    public Child getChildById(String id) {
        ChildPO childPO = childMapper.selectById(id);
        List<ChildPropertyPO> childPropertyPOS = childPropertyMapper.selectList(
                Wrappers.<ChildPropertyPO>lambdaQuery().eq(ChildPropertyPO::getChildId, id));
        List<ChildAchievementPO> childAchievementPOS = childAchievementMapper.selectList(
                Wrappers.<ChildAchievementPO>lambdaQuery().eq(ChildAchievementPO::getChildId, id));

        Map<Property, Long> properties = new HashMap<>();
        for(ChildPropertyPO childPropertyPO : childPropertyPOS) {
            properties.put(propertyRepository.getPropertyById(childPropertyPO.getPropertyId()), childPropertyPO.getValue());
        }
        ChildProperties childProperties = new ChildProperties(properties);

        List<AccomplishedAchievement> accomplishedAchievements = new ArrayList<>();
        for(ChildAchievementPO childAchievementPO :childAchievementPOS) {
            AccomplishedAchievement accomplishedAchievement = new AccomplishedAchievement(
                    achievementRepository.getAchievementById(childAchievementPO.getAchievementId()),
                    childAchievementPO.getAccomplishedTime()
            );
            accomplishedAchievements.add(accomplishedAchievement);
        }

        return new Child(childPO.getId(),
                childPO.getName(),
                childProperties,
                accomplishedAchievements);
    }

    public void saveChild(Child child) {
        ChildPO childPO = childMapper.selectById(child.getId());
        childPO.setName(child.getName());
        childMapper.updateById(childPO);

        ChildProperties childProperties = child.getChildProperties();
        for(Property property : childProperties.getProperties().keySet()) {

        }
    }

}
