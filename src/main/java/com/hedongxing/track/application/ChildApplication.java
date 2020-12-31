package com.hedongxing.track.application;

import com.hedongxing.track.model.action.Action;
import com.hedongxing.track.model.action.DrinkMilk;
import com.hedongxing.track.model.action.EatComplementaryFood;
import com.hedongxing.track.model.action.Sleep;
import com.hedongxing.track.model.Child;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChildApplication {

    public void drinkMilk(LocalDateTime time, Integer milliliter) {
        Child duomi = new Child();
        Action drinkMilk = new DrinkMilk(time, milliliter);
        duomi.complete(drinkMilk);
    }

    public void eatComplementartFood(LocalDateTime time, String foodName, double amount) {
        Child duomi = new Child();
        Action eatComplementartFood = new EatComplementaryFood(time,foodName, amount);
        duomi.complete(eatComplementartFood);
    }

    public void sleep(LocalDateTime sleepTime, LocalDateTime wakeTime){
        Child duomi = new Child();
        Action sleep = new Sleep(sleepTime, wakeTime);
        duomi.complete(sleep);
    }
}
