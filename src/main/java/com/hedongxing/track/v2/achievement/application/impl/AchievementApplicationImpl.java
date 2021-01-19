package com.hedongxing.track.v2.achievement.application.impl;

import com.hedongxing.track.v2.achievement.application.*;
import com.hedongxing.track.v2.achievement.model.Achievement;
import com.hedongxing.track.v2.achievement.model.Subject;
import com.hedongxing.track.v2.achievement.model.SubjectAchievement;
import com.hedongxing.track.v2.achievement.model.SubjectDeed;
import com.hedongxing.track.v2.achievement.model.event.SubjectAchievementAccomplished;
import com.hedongxing.track.v2.achievement.model.event.SubjectAchievementInitialized;
import com.hedongxing.track.v2.achievement.model.event.SubjectAchievementRevoked;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

import static com.hedongxing.track.v2.infrastructure.support.EventBus.PublishEvent;

@RequiredArgsConstructor
public class AchievementApplicationImpl implements AchievementApplication {

    private final SubjectDeedApplication subjectDeedApplication;

    private final ConsumptionApplication consumptionApplication;

    private final SubjectApplication subjectApplication;

    private final SubjectAchievementApplication subjectAchievementApplication;

    @Override
    public void initSubjectAchievement(String subjectId) {
        List<Achievement> achievements = getAllAchievements();
        List<SubjectAchievement> subjectAchievements = new ArrayList<>();
        Integer achievementPoints = 0;
        for(Achievement achievement : achievements) {
            SubjectAchievement subjectAchievement = new SubjectAchievement();
            subjectAchievement.setId(UUID.randomUUID().toString());
            subjectAchievement.setSubjectId(subjectId);
            subjectAchievement.setAchievementId(achievement.getId());
            Map<String, Integer> progress = new HashMap<>();
            boolean isAccomplished = true;
            LocalDateTime lastDeedCompleteTime = LocalDateTime.MIN;
            for(String deedId : achievement.getDeedsRequirment().keySet()) {
                List<SubjectDeed> subjectDeedProgresses = subjectDeedApplication.getSubjectDeedsDec(subjectId, deedId);
                Integer achievementDeedRequirment = achievement.getDeedsRequirment().get(deedId);
                if(achievementDeedRequirment > subjectDeedProgresses.size()) {
                    isAccomplished = false;
                    progress.put(deedId, subjectDeedProgresses.size());
                }else{
                    if(lastDeedCompleteTime.isBefore(subjectDeedProgresses.get(0).getCompleteTime())){
                        lastDeedCompleteTime = subjectDeedProgresses.get(0).getCompleteTime();
                    }
                    progress.put(deedId, achievementDeedRequirment);
                }
            }
            if(isAccomplished) {
                subjectAchievement.setAccomplishTime(lastDeedCompleteTime);
                achievementPoints += achievement.getPoints();
            }
            subjectAchievements.add(subjectAchievement);
        }

        double originConsumptionPoints = achievementPoints * consumptionApplication.getExchangeRate(subjectId);

        Subject subject = new Subject();
        subject.setId(subjectId);
        subject.setAchievementPoints(achievementPoints);
        subject.setConsumptionPoints(originConsumptionPoints);

        PublishEvent(new SubjectAchievementInitialized(subject));
    }

    @Override
    public void updateSubjectAchievement(String subjectId, String deedId, LocalDateTime completeTime) {
        List<Achievement> achievements = getUnaccomplishedRelatedDeedAchievements(subjectId, deedId);
        for(Achievement achievement : achievements) {
            if(subjectDeedApplication.isMeetAchievementRequirements(subjectId, achievement.getId())) {
                SubjectAchievement subjectAchievement = new SubjectAchievement();
                subjectAchievement.setId(UUID.randomUUID().toString());
                subjectAchievement.setSubjectId(subjectId);
                subjectAchievement.setAchievementId(achievement.getId());
                subjectAchievement.setAccomplishTime(completeTime);
                double consumptionPoints = achievement.getPoints() * consumptionApplication.getExchangeRate(subjectId);
                PublishEvent(new SubjectAchievementAccomplished(this, subjectId, achievement.getPoints(), consumptionPoints, subjectAchievement));
            }

        }
    }

    @Override
    public void reviewSubjectAchievement(String subjectDeedId) {
        SubjectDeed subjectDeed = subjectDeedApplication.getSubjectDeedById(subjectDeedId);
        List<Achievement> achievements = getAccomplishedRelatedDeedAchievements(subjectDeed.getSubjectId(), subjectDeed.getDeedId());
        for(Achievement achievement : achievements) {
            if(!subjectDeedApplication.isMeetAchievementRequirements(subjectDeed.getSubjectId(), achievement.getId())) {
                SubjectAchievement subjectAchievement = subjectAchievementApplication.
                        getSubjectAchievementByAchievementId(subjectDeed.getSubjectId(), achievement.getId());
                PublishEvent(new SubjectAchievementRevoked(this, subjectAchievement));
            }
        }
    }

    @Override
    public List<Achievement> getAllAchievements() {
        return null;
    }

    @Override
    public List<Achievement> getUnaccomplishedRelatedDeedAchievements(String subjectId, String deedId) {
        return null;
    }

    @Override
    public List<Achievement> getAccomplishedRelatedDeedAchievements(String subjectId, String deedId) {
        return null;
    }

    @Override
    public Achievement getAchievementById(String achievementId) {
        return null;
    }
}
