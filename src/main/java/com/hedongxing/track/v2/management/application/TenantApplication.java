package com.hedongxing.track.v2.management.application;

public interface TenantApplication {

    /**
     * 创建新租户
     * @param globalUserId 创建人globalId
     * @param kitSerialNumber 套件ID
     * @param name
     * @param description
     */
    void createTenant(String globalUserId, String kitSerialNumber, String name, String description);

    /**
     * 加入到租户
     * @param tenantId
     * @param globalUserId
     * @param nickName
     * @param title
     */
    void joinTenant(String tenantId, String globalUserId, String nickName, String title);
}
