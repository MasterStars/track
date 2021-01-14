package com.hedongxing.track.v1.achievement.model;

import com.hedongxing.track.v1.achievement.infrastructure.persistence.ActionRepositoryImpl;
import com.hedongxing.track.v1.infrastructure.util.SpringBeanUtil;

import java.util.List;

public class ActionRepository {

    public static List<Action> getChildActionRecords(String childId) {
        return SpringBeanUtil.getBean(ActionRepositoryImpl.class).getChildActionRecords(childId);
    }
}
