package com.hedongxing.track.v2.infrastructure.support;

import org.springframework.context.ApplicationEvent;

/**
 * 消息，用于不同限界上下文中通信
 */
public class Message extends ApplicationEvent {

    public Message(Object source) {
        super(source);
    }
}
