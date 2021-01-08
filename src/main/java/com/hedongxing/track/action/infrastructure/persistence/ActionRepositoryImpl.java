package com.hedongxing.track.action.infrastructure.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.action.model.*;
import com.hedongxing.track.infrastructure.mapper.*;
import com.hedongxing.track.infrastructure.po.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ActionRepositoryImpl {

    private final DrinkMilkMapper drinkMilkMapper;

    private final EatAppleMapper eatAppleMapper;

    private final EatBananaMapper eatBananaMapper;

    private final MeasureWeightMapper measureWeightMapper;

    private final MeasureHeightMapper measureHeightMapper;

    private final SleepMapper sleepMapper;

    public List<Action> getChildAllActionsOrderedAsc(String childId) {
        List<Action> actions = new LinkedList<>();

        actions.addAll(getChildActions(childId, drinkMilkMapper));
        actions.addAll(getChildActions(childId, eatAppleMapper));
        actions.addAll(getChildActions(childId, eatBananaMapper));
        actions.addAll(getChildActions(childId, measureHeightMapper));
        actions.addAll(getChildActions(childId, measureWeightMapper));
        actions.addAll(getChildActions(childId, sleepMapper));

        Collections.sort(actions);

        return actions;
    }

    private <T extends ActionPO> List<Action> getChildActions(String childId, BaseMapper<T> baseMapper) {
        List<T> actionPOS = baseMapper.selectList(Wrappers.<T>lambdaQuery().eq(T::getChildId, childId));
        List<Action> actions = new LinkedList<>();
        for(T t : actionPOS) {
            actions.add(t.transformToAction());
        }
        return actions;
    }

    public void saveAction(String childId, Action action) {
        if(action instanceof DrinkMilk) {
            DrinkMilk drinkMilk = (DrinkMilk) action;
            DrinkMilkPO drinkMilkPO = new DrinkMilkPO();
            drinkMilkPO.setId(UUID.randomUUID().toString());
            drinkMilkPO.setChildId(childId);
            drinkMilkPO.setMilliliters(drinkMilk.getMilliliters());
            drinkMilkPO.setDrinkTime(drinkMilk.getActionTime());
            drinkMilkMapper.insert(drinkMilkPO);
        }
        if(action instanceof EatApple) {
            EatApple eatApple = (EatApple) action;
            EatApplePO eatApplePO = new EatApplePO();
            eatApplePO.setId(UUID.randomUUID().toString());
            eatApplePO.setChildId(childId);
            eatApplePO.setAmount(eatApple.getAmount());
            eatApplePO.setEatTime(eatApple.getActionTime());
            eatAppleMapper.insert(eatApplePO);
        }
        if(action instanceof MeasureHeight) {
            MeasureHeight measureHeight = (MeasureHeight) action;
            MeasureHeightPO measureHeightPO = new MeasureHeightPO();
            measureHeightPO.setId(UUID.randomUUID().toString());
            measureHeightPO.setChildId(childId);
            measureHeightPO.setCentimeter(measureHeight.getCentimeter());
            measureHeightPO.setMeasureTime(measureHeight.getActionTime());
            measureHeightMapper.insert(measureHeightPO);
        }
        if(action instanceof MeasureWeight) {
            MeasureWeight measureWeight = (MeasureWeight) action;
            MeasureWeightPO measureWeightPO = new MeasureWeightPO();
            measureWeightPO.setId(UUID.randomUUID().toString());
            measureWeightPO.setChildId(childId);
            measureWeightPO.setGram(measureWeight.getGram());
            measureWeightPO.setMeasureTime(measureWeight.getActionTime());
            measureWeightMapper.insert(measureWeightPO);
        }
        if(action instanceof Sleep) {
            Sleep sleep = (Sleep) action;
            SleepPO sleepPO = new SleepPO();
            sleepPO.setId(UUID.randomUUID().toString());
            sleepPO.setChildId(childId);
            sleepPO.setSleepTime(sleep.getSleepTime());
            sleepPO.setWakeTime(sleep.getWakeTime());
            sleepMapper.insert(sleepPO);
        }
    }

}
