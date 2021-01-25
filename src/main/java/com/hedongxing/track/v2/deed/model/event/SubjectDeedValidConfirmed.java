package com.hedongxing.track.v2.deed.model.event;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.infrastructure.support.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SubjectDeedValidConfirmed extends DomainEvent {

    private SubjectDeed subjectDeed;

    private LocalDateTime confirmTime;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SubjectDeedValidConfirmed(Object source, SubjectDeed subjectDeed, LocalDateTime confirmTime) {
        super(source);
        this.subjectDeed = subjectDeed;
        this.confirmTime = confirmTime;
    }
}
