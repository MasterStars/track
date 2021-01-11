package com.hedongxing.track.application;

import com.hedongxing.track.infrastructure.dto.SavePropertyDTO;
import com.hedongxing.track.infrastructure.mapper.PropertyMapper;
import com.hedongxing.track.infrastructure.po.PropertyPO;
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
