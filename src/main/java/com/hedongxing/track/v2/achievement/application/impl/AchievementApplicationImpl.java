package com.hedongxing.track.v2.achievement.application.impl;

import com.hedongxing.track.v2.achievement.application.AchievementApplication;
import com.hedongxing.track.v2.achievement.application.ConsumptionApplication;
import com.hedongxing.track.v2.achievement.application.SubjectApplication;
import com.hedongxing.track.v2.achievement.application.SubjectDeedApplication;
import com.hedongxing.track.v2.achievement.model.Achievement;
import com.hedongxing.track.v2.achievement.model.Subject;
import com.hedongxing.track.v2.achievement.model.SubjectAchievement;
import com.hedongxing.track.v2.achievement.model.SubjectDeed;
import com.hedongxing.track.v2.achievement.model.event.SubjectAchievementInitialized;
import com.hedongxing.track.v2.achievement.model.event.SubjectAchievementUpdated;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

import static com.hedongxing.track.v2.infrastructure.support.EventPublisher.PUBLISH;

@RequiredArgsConstructor
public class AchievementApplicationImpl implements AchievementApplication {

    private final SubjectDeedApplication subjectDeedApplication;

    private final ConsumptionApplication consumptionApplication;

    private final SubjectApplication subjectApplication;

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
            subjectAchievement.setProgress(progress);
            subjectAchievement.setIsAccomplished(isAccomplished);
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
        subject.setSubjectAchievements(subjectAchievements);

        PUBLISH(new SubjectAchievementInitialized(subject));
    }

    @Override
    public void updateSubjectAchievement(String subjectId, String deedId, LocalDateTime completeTime) {
        Subject subject = subjectApplication.getSubjectById(subjectId);
        List<Achievement> achievements = getAllAchievements();
        List<SubjectAchievement> subjectAchievements = subject.getSubjectAchievements();
        Integer achievementPoints = subject.getAchievementPoints();
        for(SubjectAchievement subjectAchievement : subjectAchievements) {
            if(!subjectAchievement.getIsAccomplished()) {
                if(subjectAchievement.getProgress().containsKey(deedId)) {
                    PUBLISH(new SubjectAchievementUpdated(subjectAchievement));
                }
            }
        }
    }

    @Override
    public List<Achievement> getAllAchievements() {
        return null;
    }

    @Override
    public Achievement getAchievementById(String achievementId) {
        return null;
    }
}
