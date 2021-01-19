package com.hedongxing.track.v2.deed.model.message;

import com.hedongxing.track.v2.infrastructure.support.Message;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SubjectDeedCompleted extends Message {

    private String subjectId;

    private String deedId;

    private LocalDateTime completeTime;

    public SubjectDeedCompleted(Object source, String subjectId, String deedId, LocalDateTime completeTime) {
        super(source);
        this.subjectId = subjectId;
        this.deedId = deedId;
        this.completeTime = completeTime;
    }
}
