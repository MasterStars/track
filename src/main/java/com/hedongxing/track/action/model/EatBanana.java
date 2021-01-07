package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EatBanana extends EatFruit {

    public static final String EAT_BANANA_CODE = "eat-banana";

    public EatBanana(LocalDateTime eatTime, long amount) {
        super(eatTime, "banana", amount);
    }

    @Override
    public void execute(Child child) {
        child.updateProperties("单次吃香蕉个数", getAmount());

        updateHasEatenFruitCategories(child);
    }

    @Override
    public String printDetail() {
        return getActionTime() + ": 吃香蕉" + getAmount() + "根";
    }
}
