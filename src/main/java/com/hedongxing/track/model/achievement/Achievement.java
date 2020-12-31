package com.hedongxing.track.model.achievement;

import com.hedongxing.track.model.action.Action;

public interface Achievement {

    int getScore();

    boolean isAccomplishedOn(Action action);
}
