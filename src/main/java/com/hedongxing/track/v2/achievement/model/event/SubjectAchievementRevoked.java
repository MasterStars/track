package com.hedongxing.track.v2.achievement.model.event;

import com.hedongxing.track.v2.achievement.model.SubjectAchievement;
import com.hedongxing.track.v2.infrastructure.support.DomainEvent;

public class SubjectAchievementRevoked extends DomainEvent {

    private SubjectAchievement subjectAchievement;

    public SubjectAchievementRevoked(Object source, SubjectAchievement subjectAchievement) {
        super(source);
        this.subjectAchievement = subjectAchievement;
    }
}
