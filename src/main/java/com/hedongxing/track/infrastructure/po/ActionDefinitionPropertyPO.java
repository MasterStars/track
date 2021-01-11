package com.hedongxing.track.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("action_definition_property")
public class ActionDefinitionPropertyPO {

    String id;

    String actionDefinitionId;

    String propertyId;

    /**
     * 类型 1：累加；2：替換
     */
    Integer type;
}
