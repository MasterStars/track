package com.hedongxing.track.v1.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("property")
public class PropertyPO {

    String id;

    String name;

    String unit;

    /**
     * 类型 1：累加；2：替換;3: 互斥累加
     */
    Integer type;
}
