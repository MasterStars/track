package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;

import java.time.LocalDateTime;

public class EatApple extends EatFruit {

    public static final String EAT_APPLE_CODE = "eat-apple";

    public EatApple(LocalDateTime eatTime, long amount) {
        super(eatTime, "apple", amount);
    }

    @Override
    public void execute(Child child) {
        updateHasEatenFruitCategories(child);
    }

    @Override
    public String printDetail() {
        return getActionTime() + ": 吃苹果" + getAmount() + "个";
    }
}
