package com.hedongxing.track.v2.achievement.application;

import com.hedongxing.track.v2.achievement.model.Achievement;

import java.time.LocalDateTime;
import java.util.List;

public interface AchievementApplication {

    /**
     * 更新主角的成就
     * @param subjectId
     */
    void initSubjectAchievement(String subjectId);

    void updateSubjectAchievement(String subjectId, String deedId, LocalDateTime completeTime);

    List<Achievement> getAllAchievements();

    Achievement getAchievementById(String achievementId);
}
