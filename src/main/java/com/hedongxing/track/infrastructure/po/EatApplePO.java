package com.hedongxing.track.infrastructure.po;

import com.hedongxing.track.action.model.Action;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EatApplePO extends ActionPO {

    private Integer amount;

    private LocalDateTime eatTime;

    @Override
    public Action transformToAction() {
        return null;
    }
}
