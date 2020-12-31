package com.hedongxing.track.achievement.action;

import java.time.LocalDateTime;

public class EatComplementaryFood extends Action {

    private String foodName;

    private double amount;

    public EatComplementaryFood(LocalDateTime eatTime, String foodName, double amount) {
        super(eatTime);
        this.foodName = foodName;
        this.amount = amount;
    }

    @Override
    public String actionCode() {
        return "EatComplementaryFood";
    }
}
