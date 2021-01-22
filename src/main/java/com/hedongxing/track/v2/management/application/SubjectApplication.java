package com.hedongxing.track.v2.management.application;

public interface SubjectApplication {

    /**
     * 添加主角
     * @param tenantId
     * @param userId
     */
    void addSubject(String tenantId, String userId);
}
