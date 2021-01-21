package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.GlobalUserTenantMapper;
import com.hedongxing.track.v2.infrastructure.mapper.TenantMapper;
import com.hedongxing.track.v2.infrastructure.po.GlobalUserTenantPO;
import com.hedongxing.track.v2.infrastructure.po.TenantPO;
import com.hedongxing.track.v2.management.application.TenantApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenantApplicationImpl implements TenantApplication {

    private final TenantMapper tenantMapper;

    private final GlobalUserTenantMapper globalUserTenantMapper;

    @Override
    public void createTenant(String globalUserId, String name, String description) {
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
    }
}
