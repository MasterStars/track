package com.hedongxing.track.achievement;

import com.hedongxing.track.achievement.action.Action;

public interface Achievement {

    int getScore();

    boolean isAccomplishedOn(Action action);
}
