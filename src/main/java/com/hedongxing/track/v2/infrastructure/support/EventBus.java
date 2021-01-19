package com.hedongxing.track.v2.infrastructure.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EventBus implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        EventBus.applicationContext = applicationContext;
    }

    public static void PublishEvent(DomainEvent event) {
        applicationContext.publishEvent(event);
    }

    public static void PublishMessage(Message message) {applicationContext.publishEvent(message);}
}
