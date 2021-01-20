package com.hedongxing.track.v2.infrastructure.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPO {

    String id;

    String tenantId;

    String account;

    String password;

    String name;

    String nickname;

    LocalDate birthday;

    Integer sex;

    String phone;

    String email;
}
