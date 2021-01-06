package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public abstract class EatFruit extends Action {

    public static final String EAT_FRUIT_CODE = "eat-fruit";

    private String fruitName;

    private long amount;

    public EatFruit(LocalDateTime eatTime, String fruitName, long amount) {
        super(EAT_FRUIT_CODE, eatTime);
        this.fruitName = fruitName;
        this.amount = amount;
    }

    protected void updateHasEatenFruitCategories(Child child) {
        long fruitCategories = child.getProperties().get("水果食用种类");

        Set<String> eatenFruitNames = new HashSet<>();
        List<Action> eatFruitActions = ActionRepository.findActionRecordsOf(EAT_FRUIT_CODE);
        for(Action action : eatFruitActions) {
            EatFruit eatFruit = (EatFruit) action;
            eatenFruitNames.add(eatFruit.getFruitName());
        }
        if(!eatenFruitNames.contains(getFruitName())) {
            fruitCategories ++;
        }
        child.getProperties().update("水果食用种类", fruitCategories);
    }
}
