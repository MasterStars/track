package com.hedongxing.track.v2.achievement.model.handler;

import com.hedongxing.track.v2.achievement.application.AchievementApplication;
import com.hedongxing.track.v2.deed.model.message.SubjectDeedCompleted;
import com.hedongxing.track.v2.infrastructure.support.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectDeedCompletedHandler extends MessageHandler<SubjectDeedCompleted> {

    private final AchievementApplication achievementApplication;

    @Override
    protected void handle(SubjectDeedCompleted message) {
        achievementApplication.updateSubjectAchievement(message.getSubjectId(), message.getDeedId(), message.getCompleteTime());
    }
}
