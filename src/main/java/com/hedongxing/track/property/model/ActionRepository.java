package com.hedongxing.track.property.model;

import com.hedongxing.track.property.infrastructure.persistence.ActionRepositoryImpl;
import com.hedongxing.track.infrastructure.util.SpringBeanUtil;

import java.util.List;

public class ActionRepository {

    public static List<Action> getChildActionRecords(String childId) {
        return SpringBeanUtil.getBean(ActionRepositoryImpl.class).getChildActionRecords(childId);
    }
}
