package com.hedongxing.track.achievement.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PropertyRepository {

    private static Map<String, Property> properties = new HashMap<>();

    public PropertyRepository() {
        properties.put("单次睡眠时长", new Property("单次睡眠时长", "秒"));
        properties.put("睡眠总时长", new Property("睡眠总时长", "秒"));
        properties.put("单次喝奶量", new Property("单次喝奶量", "毫升"));
        properties.put("喝奶总量", new Property("喝奶总量", "毫升"));
        properties.put("肉类总食用量", new Property("肉类总食用量", "毫克"));
        properties.put("蔬菜食用种类", new Property("蔬菜食用种类", "种"));
        properties.put("水果食用种类", new Property("水果食用种类", "种"));
        properties.put("单次吃香蕉个数", new Property("单次吃香蕉个数", "个"));
    }

    public static Set<Property> allPrperties() {
        return new HashSet<>(properties.values());
    }



    public static Property getProperty(String name) {
        if(properties.containsKey(name)){
            return properties.get(name);
        }
        throw new RuntimeException("no such property in repository!");
    }
}
