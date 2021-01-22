package com.hedongxing.track.v2.management.application;

import java.util.List;

public interface RewardReleaserApplication {

    /**
     * 添加奖励发放人
     * @param tenantId
     * @param userId
     */
    void addRewardReleaser(String tenantId, String userId);

    List<String> getRewardReleaserOfSubject(String subjectId);
}
