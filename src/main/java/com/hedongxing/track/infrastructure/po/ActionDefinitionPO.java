package com.hedongxing.track.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("action_definition")
public class ActionDefinitionPO {

    String id;

    String actionWord;

    String name;
}
