package com.hedongxing.track.achievement.model;

import com.hedongxing.track.achievement.infrastructure.persistence.ActionRepositoryImpl;
import com.hedongxing.track.infrastructure.util.SpringBeanUtil;

import java.util.List;

public class ActionRepository {

    public static List<Action> getChildActionRecords(String childId) {
        return SpringBeanUtil.getBean(ActionRepositoryImpl.class).getChildActionRecords(childId);
    }
}
