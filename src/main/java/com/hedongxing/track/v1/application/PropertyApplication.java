package com.hedongxing.track.v1.application;

import com.hedongxing.track.v1.infrastructure.dto.SavePropertyDTO;
import com.hedongxing.track.v1.infrastructure.mapper.PropertyMapper;
import com.hedongxing.track.v1.infrastructure.po.PropertyPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PropertyApplication {

    private final PropertyMapper propertyMapper;

    public void addProperty(SavePropertyDTO savePropertyDTO) {
        PropertyPO propertyPO = new PropertyPO();
        propertyPO.setId(UUID.randomUUID().toString());
        propertyPO.setName(savePropertyDTO.getName());
        propertyPO.setUnit(savePropertyDTO.getUnit());
        propertyMapper.insert(propertyPO);
    }

    public void updateProperty(String propertyId, SavePropertyDTO savePropertyDTO) {
        PropertyPO propertyPO = new PropertyPO();
        propertyPO.setId(propertyId);
        propertyPO.setName(savePropertyDTO.getName());
        propertyPO.setUnit(savePropertyDTO.getUnit());
        propertyMapper.updateById(propertyPO);
    }
}
