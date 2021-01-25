package com.hedongxing.track.v2.deed.application;

import java.time.LocalDateTime;

public interface DeedApplication {

    /**
     * 将主角完成的事迹提交
     * @param submitterId 提交人ID
     * @param subjectId 主角ID
     * @param deedId 事迹ID
     * @param attachments 附件
     * @param completeTime 事迹完成时间
     */
    void submitDeed(String submitterId, String subjectId, String deedId, String attachments, LocalDateTime completeTime);

    /**
     * 奖励发放人确认事迹有效
     * @param subjectDeedId 主角事迹ID
     * @param rewardReleaserId
     * @param confirmTime
     */
    void confirmDeedValid(String subjectDeedId, String rewardReleaserId, LocalDateTime confirmTime);

    /**
     * 奖励发放人确认事迹无效
     * @param subjectDeedId
     * @param rewardReleaserId
     * @param reason
     * @param confirmTime
     */
    void confirmDeedInvalid(String subjectDeedId, String rewardReleaserId, String reason, LocalDateTime confirmTime);

    /**
     * 监察者将事迹设为无效
     * @param subjectDeedId
     * @param supervisorId
     * @param reason
     * @param setTime
     */
    void supervisorSetDeedInvalid(String subjectDeedId, String supervisorId, String reason, LocalDateTime setTime);
}
