package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.achievement.model.ChildProperties;

import java.time.LocalDateTime;

public class MeasureHeight extends Action {

    private static final String MEASURE_HEIGHT_CODE = "measure-height";

    private long centimeter;

    public MeasureHeight(LocalDateTime measureTime, long centimeter) {
        super(MEASURE_HEIGHT_CODE, measureTime);
        this.centimeter = centimeter;
    }

    @Override
    public void execute(Child child) {
        child.getProperties().put("身高", centimeter);
    }
}
