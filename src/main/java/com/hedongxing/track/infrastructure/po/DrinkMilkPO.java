package com.hedongxing.track.infrastructure.po;

import com.hedongxing.track.action.model.Action;
import com.hedongxing.track.action.model.DrinkMilk;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrinkMilkPO extends ActionPO {

    Integer milliliters;

    LocalDateTime drinkTime;

    public Action transformToAction() {
        return new DrinkMilk(drinkTime, milliliters);
    }
}
