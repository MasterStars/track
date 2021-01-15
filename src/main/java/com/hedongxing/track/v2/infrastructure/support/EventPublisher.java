package com.hedongxing.track.v2.infrastructure.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

public class EventPublisher implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        EventPublisher.applicationContext = applicationContext;
    }

    public static void PUBLISH(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }
}
