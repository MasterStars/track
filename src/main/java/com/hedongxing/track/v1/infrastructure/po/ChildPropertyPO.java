package com.hedongxing.track.v1.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("child_property")
public class ChildPropertyPO {

    String id;

    String childId;

    String propertyId;

    Long value;
}
