package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.UserMapper;
import com.hedongxing.track.v2.infrastructure.po.UserPO;
import com.hedongxing.track.v2.management.application.AchievementKitApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AchievementKitApplicationImpl implements AchievementKitApplication {

    private final UserMapper userMapper;

    @Override
    public void createAchievementKit(String tenantId, String userId, String serialNumber, String name, String description) {
        UserPO userPO = userMapper.selectById(userId);

    }

    @Override
    public void createOfficalAchievementKit(String serialNumber, String name, String description) {

    }
}
