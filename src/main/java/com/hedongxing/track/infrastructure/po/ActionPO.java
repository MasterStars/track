package com.hedongxing.track.infrastructure.po;

import com.hedongxing.track.action.model.Action;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ActionPO {

    String id;

    String childId;

    public abstract Action transformToAction();
}
