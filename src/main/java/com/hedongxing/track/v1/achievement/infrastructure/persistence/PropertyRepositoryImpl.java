package com.hedongxing.track.v1.achievement.infrastructure.persistence;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v1.achievement.model.Property;
import com.hedongxing.track.v1.infrastructure.mapper.ChildPropertyMapper;
import com.hedongxing.track.v1.infrastructure.mapper.PropertyMapper;
import com.hedongxing.track.v1.infrastructure.po.ChildPropertyPO;
import com.hedongxing.track.v1.infrastructure.po.PropertyPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PropertyRepositoryImpl {

    private final PropertyMapper propertyMapper;

    private final ChildPropertyMapper childPropertyMapper;

    public Set<Property> fetchAllProperties() {
        Set<Property> properties = new HashSet<>();

        for(PropertyPO propertyPO : propertyMapper.selectList(Wrappers.emptyWrapper())) {
            Property property = new Property(propertyPO.getName(), propertyPO.getUnit());
            properties.add(property);
        }
        return properties;
    }

    public Property getPropertyById(String id) {
        PropertyPO propertyPO = propertyMapper.selectById(id);
        return new Property(propertyPO.getName(), propertyPO.getUnit());
    }

    public void updateChildProperty(String childId, Property property, Long value) {
        PropertyPO propertyPO = propertyMapper.selectOne(
                Wrappers.<PropertyPO>lambdaQuery().eq(PropertyPO::getName, property.getName()));

        ChildPropertyPO childPropertyPO = childPropertyMapper.selectOne(
                Wrappers.<ChildPropertyPO>lambdaQuery().
                        eq(ChildPropertyPO::getChildId, childId).
                        eq(ChildPropertyPO::getPropertyId, propertyPO.getId()));
        if(childPropertyPO == null) {
            childPropertyPO = new ChildPropertyPO();
            childPropertyPO.setId(UUID.randomUUID().toString());
            childPropertyPO.setChildId(childId);
            childPropertyPO.setPropertyId(propertyPO.getId());
            childPropertyPO.setValue(value);
            childPropertyMapper.insert(childPropertyPO);
        }else{
            childPropertyPO.setValue(value);
            childPropertyMapper.updateById(childPropertyPO);
        }
    }
}
