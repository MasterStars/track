package com.hedongxing.track.property.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
* child属性监测器，用来监测属性变化
* @author hdx
* @since 2021/1/6 15:41
**/
public class ChildPropertiesMonitor {

    private static Map<String, Set<Property>> changedMap = new ConcurrentHashMap<>();

    public static void markAsChanged(String childId, String propertyName) {
        Set<Property> properties;
        if(changedMap.containsKey(childId)) {
            properties = changedMap.get(childId);
        }else {
            properties = new HashSet<>();
        }
        Property property = PropertyRepository.getProperty(propertyName);
        properties.add(property);
        changedMap.put(childId, properties);
    }

    public static Set<Property> getChildChangedProperties(String childId) {
        return changedMap.get(childId);
    }

    public static void removeChildProperties(String childId) {
        changedMap.remove(childId);
    }
}
