package com.hedongxing.track.v2.deed.model.event;

import com.hedongxing.track.v2.deed.model.SubjectDeed;
import com.hedongxing.track.v2.infrastructure.support.DomainEvent;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SubjectDeedInvalidConfirmed extends DomainEvent {

    private SubjectDeed subjectDeed;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SubjectDeedInvalidConfirmed(Object source, SubjectDeed subjectDeed) {
        super(source);
        this.subjectDeed = subjectDeed;
    }
}
