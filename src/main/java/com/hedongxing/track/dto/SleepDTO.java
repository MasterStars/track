package com.hedongxing.track.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SleepDTO {

    private LocalDateTime sleepTime;

    private LocalDateTime wakeTime;
}
