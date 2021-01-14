package com.hedongxing.track.v1.infrastructure.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveChildDTO {

   String name;

   Integer age;

   /**
    * 1：男，2：女
    */
   Integer sex;
}
