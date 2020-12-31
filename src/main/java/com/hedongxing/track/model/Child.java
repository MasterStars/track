package com.hedongxing.track.model;

import com.hedongxing.track.model.achievement.Achievement;
import com.hedongxing.track.model.action.Action;

import java.time.LocalDateTime;
import java.util.List;

public class Child {

    private String formalName;

    private String nickName;

    /**
     * 性别，1：男，2：女
     */
    private Integer sex;

    private Integer age;

    private Weight weight;

    private Height height;

    List<AccomplishedAchievement> accomplishedAchievements;

    public void complete(Action action) {
        for(Achievement achievement : AchievementCacheManager.getAllAchievements()) {
            if(achievement.isAccomplishedOn(action)) {
                accomplish(achievement);
            }
        }
    }

    private void accomplish(Achievement achievement) {
        accomplish(achievement, LocalDateTime.now());
    }

    private void accomplish(Achievement achievement, LocalDateTime time) {
        accomplishedAchievements.add(new AccomplishedAchievement(achievement, time));
    }

    public Integer getAchievementPoints() {
        Integer achievementPoints = 0;
        for(AccomplishedAchievement accomplishedAchievement : accomplishedAchievements) {
            achievementPoints += accomplishedAchievement.getPoints();
        }
        return achievementPoints;
    }

}
