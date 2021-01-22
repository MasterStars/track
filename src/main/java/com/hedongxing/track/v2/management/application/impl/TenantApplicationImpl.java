package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.GlobalUserTenantMapper;
import com.hedongxing.track.v2.infrastructure.mapper.TenantAchievementKitMapper;
import com.hedongxing.track.v2.infrastructure.mapper.TenantMapper;
import com.hedongxing.track.v2.infrastructure.mapper.UserMapper;
import com.hedongxing.track.v2.infrastructure.po.GlobalUserTenantPO;
import com.hedongxing.track.v2.infrastructure.po.TenantAchievementKitPO;
import com.hedongxing.track.v2.infrastructure.po.TenantPO;
import com.hedongxing.track.v2.infrastructure.po.UserPO;
import com.hedongxing.track.v2.management.application.TenantApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenantApplicationImpl implements TenantApplication {

    private final TenantMapper tenantMapper;

    private final GlobalUserTenantMapper globalUserTenantMapper;

    private final TenantAchievementKitMapper tenantAchievementKitMapper;

    private final UserMapper userMapper;

    @Override
    public void createTenant(String globalUserId, String kitSerialNumber, String name, String description) {
        TenantPO tenantPO = new TenantPO();
        tenantPO.setId(UUID.randomUUID().toString());
        tenantPO.setName(name);
        tenantPO.setDescription(description);
        tenantMapper.insert(tenantPO);

        GlobalUserTenantPO globalUserTenantPO = new GlobalUserTenantPO();
        globalUserTenantPO.setId(UUID.randomUUID().toString());
        globalUserTenantPO.setGlobalUserId(globalUserId);
        globalUserTenantPO.setTenantId(tenantPO.getId());
        globalUserTenantMapper.insert(globalUserTenantPO);

        TenantAchievementKitPO tenantAchievementKitPO = new TenantAchievementKitPO();
        tenantAchievementKitPO.setId(UUID.randomUUID().toString());
        tenantAchievementKitPO.setTenantId(tenantPO.getId());
        tenantAchievementKitPO.setKitSerialNumber(kitSerialNumber);
        tenantAchievementKitPO.setGlobalUserId(globalUserId);
        tenantAchievementKitMapper.insert(tenantAchievementKitPO);

    }

    @Override
    public void joinTenant(String tenantId, String globalUserId, String nickName, String title) {
        UserPO userPO = new UserPO();
        userPO.setId(UUID.randomUUID().toString());
        userPO.setGlobalId(globalUserId);
        userPO.setTenantId(tenantId);
        userPO.setNickname(nickName);
        userPO.setTitle(title);
        userMapper.insert(userPO);
    }
}
