package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MeasureHeight extends Action {

    private static final String MEASURE_HEIGHT_CODE = "measure-height";

    private long centimeter;

    public MeasureHeight(LocalDateTime measureTime, long centimeter) {
        super(MEASURE_HEIGHT_CODE, measureTime);
        this.centimeter = centimeter;
    }

    @Override
    public void execute(Child child) {
        child.updateProperties("身高", centimeter);
    }

    @Override
    public String printDetail() {
        return getActionTime() + ": 测量身高" + centimeter + "公分";
    }
}
