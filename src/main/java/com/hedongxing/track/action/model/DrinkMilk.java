package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.achievement.model.ChildProperties;

import java.time.LocalDateTime;

public class DrinkMilk extends Action {

    private long milliliters;

    public DrinkMilk(LocalDateTime drinkTime, long milliliters) {
        super("drink-milk", drinkTime);
        this.milliliters = milliliters;
    }

    @Override
    public void execute(Child child) {
        ChildProperties childProperties = child.getProperties();

        childProperties.put("单次喝奶量", milliliters);

        long totalMilkMilliters = milliliters + childProperties.get("喝奶总量");
        childProperties.put("喝奶总量", totalMilkMilliters);

        child.updateAccomplishedAchievements();
    }
}
