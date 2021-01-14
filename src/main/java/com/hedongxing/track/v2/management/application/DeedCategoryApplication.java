package com.hedongxing.track.v2.management.application;

public interface DeedCategoryApplication {

    /**
     * 添加事迹种类
     * @param id 种类ID
     * @param tenantId 租户ID
     * @param parentId 父种类ID
     * @param name 种类名称
     */
    void addCategory(String id, String tenantId, String parentId, String name);

}
