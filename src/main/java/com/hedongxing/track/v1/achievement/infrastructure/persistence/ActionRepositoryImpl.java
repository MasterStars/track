package com.hedongxing.track.v1.achievement.infrastructure.persistence;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.v1.achievement.model.Action;
import com.hedongxing.track.v1.achievement.model.Property;
import com.hedongxing.track.infrastructure.mapper.*;
import com.hedongxing.track.infrastructure.po.*;
import com.hedongxing.track.v1.infrastructure.mapper.*;
import com.hedongxing.track.v1.infrastructure.po.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class ActionRepositoryImpl {

    private final ActionMapper actionMapper;

    private final ActionDefinitionMapper actionDefinitionMapper;

    private final ActionDefinitionPropertyMapper actionDefinitionPropertyMapper;

    private final ActionPropertyMapper actionPropertyMapper;

    private final PropertyRepositoryImpl propertyRepository;

    private final PropertyMapper propertyMapper;

    private final ChildActionMapper childActionMapper;

    public List<Action> getChildActionRecords(String childId) {
        List<Action> actions = new ArrayList<>();

        List<ActionPO> actionPOS = actionMapper.getActionsByChildId(childId);
        for(ActionPO actionPO : actionPOS) {
            List<ActionPropertyPO> actionPropertyPOS =
                    actionPropertyMapper.selectList(Wrappers.<ActionPropertyPO>lambdaQuery().eq(
                            ActionPropertyPO::getActionId, actionPO.getId()
                    ));
            List<ActionDefinitionPropertyPO> actionDefinitionPropertyPOS =
                    actionDefinitionPropertyMapper.selectList(Wrappers.<ActionDefinitionPropertyPO>lambdaQuery().eq(
                            ActionDefinitionPropertyPO::getActionDefinitionId, actionPO.getActionDefinitionId()
                    ));
            Map<Property, Long> gainedProperties = new HashMap<>();
            Map<Property, Long> replacedProperties = new HashMap<>();
            for(ActionPropertyPO actionPropertyPO : actionPropertyPOS) {
                if(propertyMapper.selectById(actionPropertyPO.getPropertyId()).getType() == 1) {
                    gainedProperties.put(propertyRepository.getPropertyById(actionPropertyPO.getPropertyId()),
                            actionPropertyPO.getValue());
                }else{
                    replacedProperties.put(propertyRepository.getPropertyById(actionPropertyPO.getPropertyId()),
                            actionPropertyPO.getValue());
                }
            }
            ActionDefinitionPO actionDefinitionPO =
                    actionDefinitionMapper.selectOne(Wrappers.<ActionDefinitionPO>lambdaQuery().eq(
                            ActionDefinitionPO::getId, actionPO.getActionDefinitionId()
                    ));

            actions.add(new Action(actionDefinitionPO.getName(),
                    actionPO.getActionTime(),
                    gainedProperties,
                    replacedProperties,
                    actionPO.getDetail()));
        }

        return actions;
    }

    private String getActionDetail(String pattern, String[] argumentKeys, Map<String, String> argumentMap) {
        String[] arguments = new String[argumentKeys.length];
        for(int i = 0;i < arguments.length;i++) {
            arguments[i] = argumentMap.get(argumentKeys[i]);
        }
        return MessageFormat.format(pattern, arguments);
    }

    public void addAction(String childId, Action action) {
        ActionDefinitionPO actionDefinitionPO = actionDefinitionMapper.selectOne(
                Wrappers.<ActionDefinitionPO>lambdaQuery().eq(ActionDefinitionPO::getActionWord, action.getActionWord()));
        ActionPO actionPO = new ActionPO();
        actionPO.setId(UUID.randomUUID().toString());
        actionPO.setActionDefinitionId(actionDefinitionPO.getId());
        actionPO.setActionTime(action.getActionTime());
        actionPO.setDetail(action.getDetail());
        actionMapper.insert(actionPO);
        ChildActionPO childActionPO = new ChildActionPO();
        childActionPO.setId(UUID.randomUUID().toString());
        childActionPO.setActionId(actionPO.getId());
        childActionPO.setChildId(childId);
        childActionMapper.insert(childActionPO);
        Map<Property, Long> properties = new HashMap<>();
        properties.putAll(action.getGainedProperties());
        properties.putAll(action.getReplacedProperties());
        for(Property property : properties.keySet()) {
            PropertyPO propertyPO = propertyMapper.selectOne(
                    Wrappers.<PropertyPO>lambdaQuery().eq(PropertyPO::getName, property.getName()));
            ActionPropertyPO actionPropertyPO = new ActionPropertyPO();
            actionPropertyPO.setId(UUID.randomUUID().toString());
            actionPropertyPO.setActionId(actionPO.getId());
            actionPropertyPO.setPropertyId(propertyPO.getId());
            actionPropertyPO.setValue(properties.get(property));
            actionPropertyMapper.insert(actionPropertyPO);
        }
    }

}
