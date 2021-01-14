package com.hedongxing.track.v2.deed.application;

import java.time.LocalDateTime;
import java.util.List;

public interface DeedApplication {

    /**
     * 主角将完成的事迹发送给奖励发放人
     * @param subjectId 主角ID
     * @param deedId 事迹ID
     * @param rewardReleaserId 奖励发放人ID
     * @param completeTime 事迹完成时间
     */
    void sendDeed(String subjectId, String deedId, String rewardReleaserId, LocalDateTime completeTime);

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
