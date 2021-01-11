package com.hedongxing.track.achievement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Action {

    private String name;

    private LocalDateTime actionTime;

    private Map<Property, Long> gainedProperties;

    private String actionDetail;
}
