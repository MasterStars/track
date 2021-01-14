package com.hedongxing.track.v2.management.application;

public interface SubjectApplication {

    /**
     * 添加主角
     * @param id 主角ID
     * @param tenantId 租户ID
     * @param name 主角姓名
     * @param title 主角称呼
     * @param age 主角年龄
     */
    void addSubject(String id, String tenantId, String name, String title, Integer age);
}
