package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;

import java.time.LocalDateTime;
import java.util.Map;

public class DrinkMilk extends Action {

    private Integer milliliters;

    public DrinkMilk(LocalDateTime drinkTime, Integer milliliters) {
        super("drink-milk", drinkTime);
        this.milliliters = milliliters;
    }

    @Override
    public void execute(Child child) {
        Map<String, Object> childProperties = child.getProperties();

        childProperties.put("single-milk-milliliters", milliliters);

        Integer totalMilkMilliters = milliliters;
        if(childProperties.containsKey("total-milk-milliliters")) {
            totalMilkMilliters += (Integer) childProperties.get("total-milk-milliliters");
        }
        childProperties.put("total-milk-milliliters", totalMilkMilliters);

        child.updateAccomplishedAchievements();
    }
}
