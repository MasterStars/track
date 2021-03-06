package com.hedongxing.track.v1.application;

import com.hedongxing.track.v1.infrastructure.dto.SaveActionDefinitionDTO;
import com.hedongxing.track.v1.infrastructure.mapper.ActionDefinitionMapper;
import com.hedongxing.track.v1.infrastructure.mapper.ActionDefinitionPropertyMapper;
import com.hedongxing.track.v1.infrastructure.po.ActionDefinitionPO;
import com.hedongxing.track.v1.infrastructure.po.ActionDefinitionPropertyPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActionApplication {

    private final ActionDefinitionMapper actionDefinitionMapper;

    private final ActionDefinitionPropertyMapper actionDefinitionPropertyMapper;

    public void addActionDefinition(SaveActionDefinitionDTO saveActionDefinitionDTO) {
        ActionDefinitionPO actionDefinitionPO = new ActionDefinitionPO();
        actionDefinitionPO.setId(UUID.randomUUID().toString());
        actionDefinitionPO.setActionWord(saveActionDefinitionDTO.getActionWord());
        actionDefinitionPO.setName(saveActionDefinitionDTO.getName());
        actionDefinitionMapper.insert(actionDefinitionPO);

        for(String propertyId : saveActionDefinitionDTO.getProperties().keySet()) {
            ActionDefinitionPropertyPO actionDefinitionPropertyPO = new ActionDefinitionPropertyPO();
            actionDefinitionPropertyPO.setId(UUID.randomUUID().toString());
            actionDefinitionPropertyPO.setPropertyId(propertyId);
            actionDefinitionPropertyPO.setActionDefinitionId(actionDefinitionPO.getId());
            actionDefinitionPropertyMapper.insert(actionDefinitionPropertyPO);
        }
    }
}
