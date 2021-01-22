package com.hedongxing.track.v2.management.application;

import java.util.List;

public interface SupervisorApplication {

    /**
     * 添加监察人
     * @param tenantId
     * @param userId
     */
    void addSupervisor(String tenantId, String userId);

    /**
     * 获取主角的监察人列表
     * @param subjectId
     * @return
     */
    List<String> getSupervisorsOfSubject(String subjectId);
}
