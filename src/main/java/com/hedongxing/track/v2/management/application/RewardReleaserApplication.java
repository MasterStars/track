package com.hedongxing.track.v2.management.application;

public interface RewardReleaserApplication {

    /**
     * 设置奖励发放人
     * @param id 发放人ID
     * @param tenantId 租户ID
     * @param subjectId 所发放的主角ID
     * @param name 名称
     * @param title （主角对发放人的）称呼
     */
    void setRewardReleaser(String id, String tenantId, String subjectId, String name, String title);
}
