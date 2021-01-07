package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MeasureWeight extends Action {

    private static final String MEASURE_WEIGHT_CODE = "measure-weight";

    private long gram;

    public MeasureWeight(LocalDateTime measureTime, long gram) {
        super(MEASURE_WEIGHT_CODE, measureTime);
        this.gram = gram;
    }

    @Override
    public void execute(Child child) {
        child.updateProperties("体重", gram);
    }

    @Override
    public String printDetail() {
        return getActionTime() + ": 量体重" + gram*2/1000 + "斤";
    }
}
