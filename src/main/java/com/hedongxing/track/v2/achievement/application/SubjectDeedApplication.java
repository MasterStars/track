package com.hedongxing.track.v2.achievement.application;

import com.hedongxing.track.v2.achievement.model.SubjectDeed;

import java.util.List;

public interface SubjectDeedApplication {

    List<SubjectDeed> getSubjectDeedsDec(String subjectId, String deedId);

    boolean isMeetAchievementRequirements(String subjectId, String achievementId);

    SubjectDeed getSubjectDeedById(String subjectDeedId);
}
