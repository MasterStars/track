package com.hedongxing.track.v2.achievement.application;

import com.hedongxing.track.v2.achievement.model.Achievement;

import java.time.LocalDateTime;
import java.util.List;

public interface AchievementApplication {

    /**
     * 初始化主角的成就
     * @param subjectId
     */
    void initSubjectAchievement(String subjectId);

    void updateSubjectAchievement(String subjectId, String deedId, LocalDateTime completeTime);

    void reviewSubjectAchievement(String subjectDeedId);

    List<Achievement> getAllAchievements();

    /**
     * 获取主角的与指定事迹相关的未完成成就
     * @param subjectId
     * @param deedId
     * @return
     */
    List<Achievement> getUnaccomplishedRelatedDeedAchievements(String subjectId, String deedId);

    List<Achievement> getAccomplishedRelatedDeedAchievements(String subjectId, String deedId);

    Achievement getAchievementById(String achievementId);
}
