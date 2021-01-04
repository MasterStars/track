package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;

import java.time.LocalDateTime;
import java.util.Map;

public class EatComplementaryFood extends Action {

    private String foodName;

    private Double amount;

    public EatComplementaryFood(LocalDateTime eatTime, String foodName, Double amount) {
        super("eat-complementary-food", eatTime);
        this.foodName = foodName;
        this.amount = amount;
    }

    @Override
    public void execute(Child child) {
        Map<String, Object> childProperties = child.getProperties();

        childProperties.put("single-" + foodName +"-amount", amount);

        Double totalAmount = amount;
        if(childProperties.containsKey("total-" + foodName + "-amount")) {
            totalAmount += (Double) childProperties.get("total-" + foodName + "-amount");
        }
        childProperties.put("total-" + foodName + "-amount", totalAmount);

        child.updateAccomplishedAchievements();
    }
}
