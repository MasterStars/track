package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.achievement.model.ChildProperties;

import java.time.LocalDateTime;

public class EatBanana extends EatFruit {

    public static final String EAT_BANANA_CODE = "eat-banana";

    public EatBanana(LocalDateTime eatTime, long amount) {
        super(eatTime, "banana", amount);
    }

    @Override
    public void execute(Child child) {
        ChildProperties childProperties = child.getProperties();
        childProperties.update("单次吃香蕉个数", getAmount());

        updateHasEatenFruitCategories(child);
    }

    @Override
    public String printDetail() {
        return getActionTime() + ": 吃香蕉" + getAmount() + "根";
    }
}
