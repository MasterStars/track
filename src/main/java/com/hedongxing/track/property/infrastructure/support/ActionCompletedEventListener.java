package com.hedongxing.track.property.infrastructure.support;

import com.hedongxing.track.property.infrastructure.event.ActionCompletedEvent;
import com.hedongxing.track.property.infrastructure.persistence.ActionRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionCompletedEventListener implements ApplicationListener<ActionCompletedEvent> {

    private final ActionRepositoryImpl actionRepository;

    @Override
    public void onApplicationEvent(ActionCompletedEvent event) {
        actionRepository.addAction(event.getChildId(), event.getAction());
    }
}
