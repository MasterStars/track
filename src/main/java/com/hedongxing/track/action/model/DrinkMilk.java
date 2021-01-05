package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.achievement.model.ChildProperties;

import java.time.LocalDateTime;

public class DrinkMilk extends Action {

    public static final String DRINK_MILK_CODE = "drink-milk";

    private long milliliters;

    public DrinkMilk(LocalDateTime drinkTime, long milliliters) {
        super(DRINK_MILK_CODE, drinkTime);
        this.milliliters = milliliters;
    }

    @Override
    public void execute(Child child) {
        ChildProperties childProperties = child.getProperties();

        childProperties.put("单次喝奶量", milliliters);

        long totalMilkMilliters = milliliters + childProperties.get("喝奶总量");
        childProperties.put("喝奶总量", totalMilkMilliters);
    }
}
