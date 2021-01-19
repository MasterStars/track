package com.hedongxing.track.v2.reward.model.event;

import com.hedongxing.track.v2.infrastructure.support.DomainEvent;
import com.hedongxing.track.v2.reward.model.ExchangeReward;

import java.time.LocalDateTime;

public class ExchangeRewardApplied extends DomainEvent {

    private ExchangeReward exchangeReward;

    private LocalDateTime applyTime;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ExchangeRewardApplied(Object source, ExchangeReward exchangeReward, LocalDateTime applyTime) {
        super(source);
        this.exchangeReward = exchangeReward;
        this.applyTime = applyTime;
    }
}
