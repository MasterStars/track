package com.hedongxing.track.achievement.infrastructure.support;

import com.hedongxing.track.achievement.infrastructure.event.ActionCompletedEvent;
import com.hedongxing.track.action.infrastructure.persistence.ActionRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionCompletedEventListener implements ApplicationListener<ActionCompletedEvent> {

    private final ActionRepositoryImpl actionRepository;

    @Override
    public void onApplicationEvent(ActionCompletedEvent event) {
        actionRepository.saveAction(event.getChildId(), event.getAction());
    }
}
