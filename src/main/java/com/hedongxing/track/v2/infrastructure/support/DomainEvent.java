package com.hedongxing.track.v2.infrastructure.support;

import org.springframework.context.ApplicationEvent;

/**
 * 领域事件，用于同个限界上下文中事件发布订阅
 */
public class DomainEvent extends ApplicationEvent {

    public DomainEvent(Object source) {
        super(source);
    }
}
