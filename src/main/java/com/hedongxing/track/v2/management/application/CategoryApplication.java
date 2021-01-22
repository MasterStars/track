package com.hedongxing.track.v2.management.application;

public interface CategoryApplication {

    /**
     * 添加种类（事迹和成就共享）
     * @param kitSerialNumber
     * @param parentId 父种类ID
     * @param name 种类名称
     */
    void addCategory(String kitSerialNumber, String parentId, String name);

    void editCategory(String categoryId, String parentId, String name);
}
