package com.hedongxing.track.v2.management.application;

public interface SupervisorApplication {

    /**
     * 设置监察人
     * @param id 监察人ID
     * @param tenantId 租户ID
     * @param subjectId 所监察的主角ID
     * @param name 名称
     * @param title （主角对监察者的）称呼
     */
    void setSupervisor(String id, String tenantId, String subjectId, String name, String title);
}
