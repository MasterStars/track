package com.hedongxing.track.v1.application;

import com.hedongxing.track.v1.infrastructure.dto.SaveAchievementDTO;
import com.hedongxing.track.v1.infrastructure.mapper.AchievementMapper;
import com.hedongxing.track.v1.infrastructure.mapper.AchievementPropertyMapper;
import com.hedongxing.track.v1.infrastructure.po.AchievementPO;
import com.hedongxing.track.v1.infrastructure.po.AchievementPropertyPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AchievementApplication {

    private final AchievementMapper achievementMapper;

    private final AchievementPropertyMapper achievementPropertyMapper;

    public void addAchievement(SaveAchievementDTO saveAchievementDTO) {
        AchievementPO achievementPO = new AchievementPO();
        achievementPO.setId(UUID.randomUUID().toString());
        achievementPO.setName(saveAchievementDTO.getName());
        achievementPO.setScore(saveAchievementDTO.getScore());
        achievementPO.setOperator(saveAchievementDTO.getOperator());
        achievementMapper.insert(achievementPO);
        for(String propertyId : saveAchievementDTO.getProperties().keySet()) {
            AchievementPropertyPO achievementPropertyPO = new AchievementPropertyPO();
            achievementPropertyPO.setId(UUID.randomUUID().toString());
            achievementPropertyPO.setAchievementId(achievementPO.getId());
            achievementPropertyPO.setPropertyId(propertyId);
            achievementPropertyPO.setCriticalValue(saveAchievementDTO.getProperties().get(propertyId));
            achievementPropertyMapper.insert(achievementPropertyPO);
        }
    }
}
