package com.hedongxing.track.v1.achievement.infrastructure.event.handler;

import com.hedongxing.track.v1.achievement.infrastructure.event.ActionCompleted;
import com.hedongxing.track.v1.achievement.infrastructure.persistence.ActionRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionCompletedListener implements ApplicationListener<ActionCompleted> {

    private final ActionRepositoryImpl actionRepository;

    @Override
    public void onApplicationEvent(ActionCompleted event) {
        actionRepository.addAction(event.getChildId(), event.getAction());
    }
}
