package com.hedongxing.track.v2.infrastructure.support;

import org.springframework.context.ApplicationListener;


public abstract class MessageHandler<E extends Message> implements ApplicationListener<E> {

    @Override
    public void onApplicationEvent(E message) {
        handle(message);
    }

    protected abstract void handle(E message);
}
