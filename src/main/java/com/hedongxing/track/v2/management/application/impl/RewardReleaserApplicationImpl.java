package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.RewardReleaserMapper;
import com.hedongxing.track.v2.infrastructure.po.RewardReleaserPO;
import com.hedongxing.track.v2.management.application.RewardReleaserApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RewardReleaserApplicationImpl implements RewardReleaserApplication {

    private final RewardReleaserMapper rewardReleaserMapper;


    @Override
    public void addRewardReleaser(String tenantId, String userId) {
        RewardReleaserPO rewardReleaserPO = new RewardReleaserPO();
        rewardReleaserPO.setId(UUID.randomUUID().toString());
        rewardReleaserPO.setTenantId(tenantId);
        rewardReleaserPO.setUserId(userId);
        rewardReleaserMapper.insert(rewardReleaserPO);
    }

    @Override
    public List<String> getRewardReleaserOfSubject(String subjectId) {
        return null;
    }
}
