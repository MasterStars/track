package com.hedongxing.track.application;

import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.achievement.model.ChildRepository;
import com.hedongxing.track.action.model.Action;
import com.hedongxing.track.action.model.DrinkMilk;
import com.hedongxing.track.action.model.Sleep;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * action产生数据变化，成就系统根据数据生成达成的成就
 */
@Service
public class ChildApplication {

    public void drinkMilk(LocalDateTime time, Integer milliliters) {
        Child duomi = ChildRepository.getChild("duomi");
        Action drinkMilk = new DrinkMilk(time, milliliters);
        duomi.complete(drinkMilk);
    }

    public void eatComplementartFood(LocalDateTime time, String foodName, double amount) {

    }

    public void sleep(LocalDateTime sleepTime, LocalDateTime wakeTime){
        Child duomi = ChildRepository.getChild("duomi");
        Action sleep = new Sleep(sleepTime, wakeTime);
        duomi.complete(sleep);
    }

    public String achievements() {
        Child duomi = ChildRepository.getChild("duomi");
        return duomi.printAccomplishedAchievements();
    }

    public String actions() {
        Child duomi = ChildRepository.getChild("duomi");
        return duomi.printActionDetails();
    }

}
