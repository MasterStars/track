package com.hedongxing.track.v2.infrastructure.support;

import org.springframework.context.ApplicationListener;

public abstract class DomainEventHandler<E extends DomainEvent> implements ApplicationListener<E> {

    @Override
    public void onApplicationEvent(E event) {
        handle(event);
    }

    protected abstract void handle(E event);
}
