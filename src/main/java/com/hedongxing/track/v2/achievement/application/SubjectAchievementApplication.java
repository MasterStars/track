package com.hedongxing.track.v2.achievement.application;

import com.hedongxing.track.v2.achievement.model.SubjectAchievement;

public interface SubjectAchievementApplication {

    SubjectAchievement getSubjectAchievementByAchievementId(String subjectId, String achievementId);
}
