package com.hedongxing.track.model.action;

import java.time.LocalDateTime;

public class DrinkMilk extends Action {

    private Integer milliliter;

    public DrinkMilk(LocalDateTime drinkTime, Integer milliliter){
        super(drinkTime);
        this.milliliter = milliliter;
    }

    @Override
    public String actionCode() {
        return "DrinkMilk";
    }

    public Integer getMilliliter() {
        return milliliter;
    }
}
