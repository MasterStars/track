package com.hedongxing.track.v1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hedongxing.track.infrastructure.mapper")
public class MyBatisPlusConfiguration {
}
