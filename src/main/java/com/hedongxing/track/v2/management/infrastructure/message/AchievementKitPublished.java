package com.hedongxing.track.v2.management.infrastructure.message;

import com.hedongxing.track.v2.infrastructure.support.Message;
import lombok.Getter;

@Getter
public class AchievementKitPublished extends Message {

    private String kitSerialNumber;

    public AchievementKitPublished(Object source, String kitSerialNumber) {
        super(source);
        this.kitSerialNumber = kitSerialNumber;
    }
}
