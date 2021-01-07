package com.hedongxing.track.action.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* 动作词典
* @author hdx
* @since 2021/1/5 15:36
**/
@AllArgsConstructor
@Getter
public enum ActionDictionary {

    DRINK_MILK("DrinkMilk", "喝奶", DrinkMilk.class),
    ;

    private String enIndex;

    private String zhCNIndex;

    private Class<?> actionClazz;




}
