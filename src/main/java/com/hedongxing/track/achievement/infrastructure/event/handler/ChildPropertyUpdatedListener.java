package com.hedongxing.track.achievement.infrastructure.event.handler;

import com.hedongxing.track.achievement.infrastructure.event.ChildPropertyUpdated;
import com.hedongxing.track.achievement.infrastructure.persistence.PropertyRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChildPropertyUpdatedListener implements ApplicationListener<ChildPropertyUpdated> {

    private final PropertyRepositoryImpl propertyRepository;

    @Override
    public void onApplicationEvent(ChildPropertyUpdated event) {
        propertyRepository.updateChildProperty(event.getChildId(),
                                                event.getUpdatedProperty(),
                                                event.getUpdatedValue());
    }
}
