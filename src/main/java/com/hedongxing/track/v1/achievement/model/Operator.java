package com.hedongxing.track.v1.achievement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Operator {

    AND("and"),

    OR("or"),
    ;

    private String code;

    public static Operator get(String code) {
        for(Operator operator : Operator.values()) {
            if(operator.getCode().equals(code)) {
                return operator;
            }
        }
        return null;
    }
}
