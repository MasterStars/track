package com.hedongxing.track.v2.reward.application;

public interface SubjectRewardApplication {

    boolean hasReceivedAchievementPointsReward(String subjectId, Integer achievementPoints);

    boolean hasReceivedAchievementReward(String subjectId, String rewardId);
}
