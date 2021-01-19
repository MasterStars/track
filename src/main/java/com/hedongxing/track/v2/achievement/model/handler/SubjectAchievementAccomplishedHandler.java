package com.hedongxing.track.v2.achievement.model.handler;

import com.hedongxing.track.v2.achievement.model.Subject;
import com.hedongxing.track.v2.achievement.model.SubjectAchievement;
import com.hedongxing.track.v2.achievement.model.event.SubjectAchievementAccomplished;
import com.hedongxing.track.v2.infrastructure.support.DomainEventHandler;
import org.springframework.stereotype.Component;

@Component
public class SubjectAchievementAccomplishedHandler extends DomainEventHandler<SubjectAchievementAccomplished> {

    @Override
    protected void handle(SubjectAchievementAccomplished event) {
        String subjectId = event.getSubjectId();
        SubjectAchievement subjectAchievement = event.getSubjectAchievement();
        //TODO 持久化subjectachievement和subject的积分
    }
}
