package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExchangeRewardPO {

    String id;

    String tenantId;

    Double consumptionPoints;

    String rewardId;
}
