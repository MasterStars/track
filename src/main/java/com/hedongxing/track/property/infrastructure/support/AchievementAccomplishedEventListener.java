package com.hedongxing.track.property.infrastructure.support;

import com.hedongxing.track.property.infrastructure.event.AchievementAccomplishedEvent;
import com.hedongxing.track.property.infrastructure.persistence.AccomplishedAchievementRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AchievementAccomplishedEventListener implements ApplicationListener<AchievementAccomplishedEvent> {

    private final AccomplishedAchievementRepositoryImpl accomplishedAchievementRepository;

    @Override
    public void onApplicationEvent(AchievementAccomplishedEvent event) {
        accomplishedAchievementRepository.addChildAccomplishedAchievement(event.getChildId(), event.getAccomplishedAchievement());
    }
}
