package com.hedongxing.track.v2.management.application.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v2.infrastructure.mapper.AchievementKitMapper;
import com.hedongxing.track.v2.infrastructure.mapper.GlobalUserAchievementKitMapper;
import com.hedongxing.track.v2.infrastructure.po.AchievementKitPO;
import com.hedongxing.track.v2.infrastructure.po.GlobalUserAchievementKitPO;
import com.hedongxing.track.v2.management.application.AchievementKitApplication;
import com.hedongxing.track.v2.management.infrastructure.message.AchievementKitPublished;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.hedongxing.track.v2.infrastructure.support.EventBus.PublishMessage;

@Service
@RequiredArgsConstructor
public class AchievementKitApplicationImpl implements AchievementKitApplication {

    private final AchievementKitMapper achievementKitMapper;

    private final GlobalUserAchievementKitMapper globalUserAchievementKitMapper;

    @Override
    public void createAchievementKit(String globalUserId, String serialNumber, String name, String description) {
        AchievementKitPO achievementKitPO = new AchievementKitPO();
        achievementKitPO.setCreaterId(globalUserId);
        achievementKitPO.setType(2);
        achievementKitPO.setName(name);
        achievementKitPO.setKitSerialNumber(serialNumber);
        achievementKitPO.setIsPublished(false);
        achievementKitPO.setDescription(description);
        achievementKitMapper.insert(achievementKitPO);

        GlobalUserAchievementKitPO globalUserAchievementKitPO = new GlobalUserAchievementKitPO();
        globalUserAchievementKitPO.setId(UUID.randomUUID().toString());
        globalUserAchievementKitPO.setGlobalUserId(globalUserId);
        globalUserAchievementKitPO.setKitSerialNumber(achievementKitPO.getKitSerialNumber());
        globalUserAchievementKitMapper.insert(globalUserAchievementKitPO);
    }

    @Override
    public void createOfficalAchievementKit(String globalUserId, String serialNumber, String name, String description) {
        AchievementKitPO achievementKitPO = new AchievementKitPO();
        achievementKitPO.setCreaterId(globalUserId);
        achievementKitPO.setType(1);
        achievementKitPO.setName(name);
        achievementKitPO.setKitSerialNumber(serialNumber);
        achievementKitPO.setIsPublished(true);
        achievementKitPO.setDescription(description);
        achievementKitMapper.insert(achievementKitPO);
    }

    @Override
    public void publishAchievementKit(String globalUserId, String serialNumber) {
        List<AchievementKitPO> achievementKits = achievementKitMapper.selectList(
                Wrappers.<AchievementKitPO>lambdaQuery().eq(AchievementKitPO::getCreaterId, globalUserId));
        for(AchievementKitPO kit : achievementKits) {
            if(kit.getKitSerialNumber().equals(serialNumber) && !kit.getIsPublished()) {
                kit.setIsPublished(true);
                achievementKitMapper.updateById(kit);
                PublishMessage(new AchievementKitPublished(this, kit.getKitSerialNumber()));
            }
        }
    }
}
