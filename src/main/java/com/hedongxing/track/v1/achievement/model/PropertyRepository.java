package com.hedongxing.track.v1.achievement.model;

import com.hedongxing.track.v1.achievement.infrastructure.persistence.PropertyRepositoryImpl;
import com.hedongxing.track.v1.exception.NoSuchPropertyException;
import com.hedongxing.track.v1.infrastructure.util.SpringBeanUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertyRepository {

    private static Map<String, Property> propertyMap = new HashMap<>();

    public PropertyRepository() {
        Set<Property> properties = SpringBeanUtil.getBean(PropertyRepositoryImpl.class).fetchAllProperties();
        for(Property property : properties) {
            propertyMap.put(property.getName(), property);
        }
    }

    public static Set<Property> allPrperties() {
        return Collections.unmodifiableSet((Set<Property>) propertyMap.values());
    }

    public static Property getProperty(String name) {
        if(propertyMap.containsKey(name)){
            return propertyMap.get(name);
        }
        throw new NoSuchPropertyException();
    }
}
