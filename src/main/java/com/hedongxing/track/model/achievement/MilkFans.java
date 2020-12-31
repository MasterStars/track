package com.hedongxing.track.model.achievement;

import com.hedongxing.track.model.action.Action;
import com.hedongxing.track.model.action.DrinkMilk;

/**
 * “牛奶粉丝”成就
 */
public class MilkFans implements Achievement {

    @Override
    public int getScore() {
        return 5;
    }

    @Override
    public boolean isAccomplishedOn(Action action) {
        if(action instanceof DrinkMilk) {
            DrinkMilk drinkMilk = (DrinkMilk)action;
            return drinkMilk.getMilliliter() > 200;
        }
        return false;
    }
}
