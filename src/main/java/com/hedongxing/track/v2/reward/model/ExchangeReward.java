package com.hedongxing.track.v2.reward.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExchangeReward {

    String id;

    String name;

    Double consumptionPoints;
}
