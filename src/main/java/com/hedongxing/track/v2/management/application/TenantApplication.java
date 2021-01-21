package com.hedongxing.track.v2.management.application;

public interface TenantApplication {

    /**
     * 创建新租户
     * @param globalUserId 创建人globalId
     * @param name
     * @param description
     */
    void createTenant(String globalUserId, String name, String description);
}
