package com.hedongxing.track.v1.achievement.infrastructure.event.handler;

import com.hedongxing.track.v1.achievement.infrastructure.event.AchievementAccomplished;
import com.hedongxing.track.v1.achievement.infrastructure.persistence.AccomplishedAchievementRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AchievementAccomplishedListener implements ApplicationListener<AchievementAccomplished> {

    private final AccomplishedAchievementRepositoryImpl accomplishedAchievementRepository;

    @Override
    public void onApplicationEvent(AchievementAccomplished event) {
        accomplishedAchievementRepository.addChildAccomplishedAchievement(event.getChildId(), event.getAccomplishedAchievement());
    }
}
