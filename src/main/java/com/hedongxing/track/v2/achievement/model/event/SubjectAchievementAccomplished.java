package com.hedongxing.track.v2.achievement.model.event;

import com.hedongxing.track.v2.achievement.model.Subject;
import com.hedongxing.track.v2.achievement.model.SubjectAchievement;
import com.hedongxing.track.v2.infrastructure.support.DomainEvent;
import lombok.Getter;

@Getter
public class SubjectAchievementAccomplished extends DomainEvent {

    private String subjectId;

    private int achievementPoints;

    private double consumptionPoints;

    private SubjectAchievement subjectAchievement;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SubjectAchievementAccomplished(Object source,
                                          String subjectId,
                                          int achievementPoints,
                                          double consumptionPoints,
                                          SubjectAchievement subjectAchievement) {
        super(source);
        this.subjectId = subjectId;
        this.achievementPoints = achievementPoints;
        this.consumptionPoints = consumptionPoints;
        this.subjectAchievement = subjectAchievement;
    }
}
