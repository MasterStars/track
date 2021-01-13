package com.hedongxing.track.property.infrastructure.support;

import com.hedongxing.track.property.infrastructure.event.ChildPropertyUpdatedEvent;
import com.hedongxing.track.property.infrastructure.persistence.PropertyRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChildPropertyUpdatedEventListener implements ApplicationListener<ChildPropertyUpdatedEvent> {

    private final PropertyRepositoryImpl propertyRepository;

    @Override
    public void onApplicationEvent(ChildPropertyUpdatedEvent event) {
        propertyRepository.updateChildProperty(event.getChildId(),
                                                event.getUpdatedProperty(),
                                                event.getUpdatedValue());
    }
}
