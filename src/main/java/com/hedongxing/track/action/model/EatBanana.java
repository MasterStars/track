package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.achievement.model.ChildProperties;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EatBanana extends EatFruit {

    public static final String EAT_BANANA_CODE = "eat-banana";

    public EatBanana(LocalDateTime eatTime, long amount) {
        super(eatTime, "banana", amount);
    }

    @Override
    public void execute(Child child) {
        ChildProperties childProperties = child.getProperties();
        childProperties.put("单次吃香蕉个数", getAmount());

        updateHasEatenFruitCategories(child);
    }
}
