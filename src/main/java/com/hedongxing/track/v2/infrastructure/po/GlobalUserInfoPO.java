package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GlobalUserInfoPO {

    String id;

    String name;

    LocalDate birthday;

    Integer sex;

    String phone;

    String email;
}
