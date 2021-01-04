package com.hedongxing.track.achievement.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChildRepository {

    private static Map<String, Child> childMap = new ConcurrentHashMap<>();

    public ChildRepository() {
        childMap.put("duomi", new Child("多米"));
        childMap.put("xiaoyu", new Child("小鱼"));
    }

    public static Child getChild(String name) {
        return childMap.get(name);
    }
}
