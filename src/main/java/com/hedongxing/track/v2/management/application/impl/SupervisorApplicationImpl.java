package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.SupervisorMapper;
import com.hedongxing.track.v2.infrastructure.po.SupervisorPO;
import com.hedongxing.track.v2.management.application.SupervisorApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupervisorApplicationImpl implements SupervisorApplication {

    private final SupervisorMapper supervisorMapper;

    @Override
    public void addSupervisor(String tenantId, String userId) {
        SupervisorPO supervisorPO = new SupervisorPO();
        supervisorPO.setId(UUID.randomUUID().toString());
        supervisorPO.setTenantId(tenantId);
        supervisorPO.setUserId(userId);
        supervisorMapper.insert(supervisorPO);
    }

    @Override
    public List<String> getSupervisorsOfSubject(String subjectId) {
        return null;
    }
}
