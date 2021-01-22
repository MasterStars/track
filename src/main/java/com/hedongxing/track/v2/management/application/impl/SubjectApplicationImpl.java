package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.SubjectMapper;
import com.hedongxing.track.v2.infrastructure.po.SubjectPO;
import com.hedongxing.track.v2.management.application.SubjectApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectApplicationImpl implements SubjectApplication {

    private final SubjectMapper subjectMapper;

    @Override
    public void addSubject(String tenantId, String userId) {
        SubjectPO subjectPO = new SubjectPO();
        subjectPO.setId(UUID.randomUUID().toString());
        subjectPO.setAchievementPoints(0);
        subjectPO.setConsumptionPoints(0.0);
        subjectPO.setUserId(userId);
        subjectPO.setTenantId(tenantId);
        subjectMapper.insert(subjectPO);
    }
}
