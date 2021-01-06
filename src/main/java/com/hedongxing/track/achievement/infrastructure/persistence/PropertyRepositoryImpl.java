package com.hedongxing.track.achievement.infrastructure.persistence;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.achievement.model.Property;
import com.hedongxing.track.infrastructure.mapper.ChildPropertyMapper;
import com.hedongxing.track.infrastructure.mapper.PropertyMapper;
import com.hedongxing.track.infrastructure.po.ChildPropertyPO;
import com.hedongxing.track.infrastructure.po.PropertyPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PropertyRepositoryImpl {

    private final PropertyMapper propertyMapper;

    private final ChildPropertyMapper childPropertyMapper;

    public Set<Property> allProperties() {
        Set<Property> properties = new HashSet<>();

        List<PropertyPO> propertyPOS = propertyMapper.selectList(Wrappers.emptyWrapper());
        for(PropertyPO propertyPO : propertyPOS) {
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

        childPropertyPO.setValue(value);

        childPropertyMapper.updateById(childPropertyPO);
    }
}
