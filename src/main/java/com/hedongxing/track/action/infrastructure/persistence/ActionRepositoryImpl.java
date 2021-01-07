package com.hedongxing.track.action.infrastructure.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.action.model.Action;
import com.hedongxing.track.infrastructure.mapper.*;
import com.hedongxing.track.infrastructure.po.ActionPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

}
