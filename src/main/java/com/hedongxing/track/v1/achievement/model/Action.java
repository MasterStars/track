package com.hedongxing.track.v1.achievement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Action {

    private String actionWord;

    private LocalDateTime actionTime;

    private Map<Property, Long> gainedProperties;

    private Map<Property, Long> replacedProperties;

    private String detail;
}
