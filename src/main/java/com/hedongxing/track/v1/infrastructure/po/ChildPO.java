package com.hedongxing.track.v1.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("child")
public class ChildPO {

    String id;

    String name;

    Integer age;

    Integer sex;

}
