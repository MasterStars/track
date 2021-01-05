package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;

import java.time.LocalDateTime;

public class MeasureWeight extends Action {

    private static final String MEASURE_WEIGHT_CODE = "measure-weight";

    private long gram;

    public MeasureWeight(LocalDateTime measureTime, Long gram) {
        super(MEASURE_WEIGHT_CODE, measureTime);
        this.gram = gram;
    }

    @Override
    public void execute(Child child) {
        child.getProperties().put("体重", gram);
    }
}
