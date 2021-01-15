package com.hedongxing.track.v2.management.application;

public interface DeedCategoryApplication {

    /**
     * 添加事迹种类
     * @param id 种类ID
     * @param kitSerialNumber
     * @param parentId 父种类ID
     * @param name 种类名称
     */
    void addCategory(String id, String kitSerialNumber, String parentId, String name);

}
