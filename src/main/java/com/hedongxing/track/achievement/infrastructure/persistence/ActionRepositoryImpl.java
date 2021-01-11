package com.hedongxing.track.achievement.infrastructure.persistence;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hedongxing.track.achievement.model.Action;
import com.hedongxing.track.achievement.model.Property;
import com.hedongxing.track.infrastructure.mapper.ActionDefinitionMapper;
import com.hedongxing.track.infrastructure.mapper.ActionDefinitionPropertyMapper;
import com.hedongxing.track.infrastructure.mapper.ActionMapper;
import com.hedongxing.track.infrastructure.mapper.ActionPropertyMapper;
import com.hedongxing.track.infrastructure.po.ActionDefinitionPO;
import com.hedongxing.track.infrastructure.po.ActionDefinitionPropertyPO;
import com.hedongxing.track.infrastructure.po.ActionPO;
import com.hedongxing.track.infrastructure.po.ActionPropertyPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ActionRepositoryImpl {

    private final ActionMapper actionMapper;

    private final ActionDefinitionMapper actionDefinitionMapper;

    private final ActionDefinitionPropertyMapper actionDefinitionPropertyMapper;

    private final ActionPropertyMapper actionPropertyMapper;

    private final PropertyRepositoryImpl propertyRepository;

    public List<Action> getChildActions(String childId) {
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
                for(ActionDefinitionPropertyPO actionDefinitionPropertyPO : actionDefinitionPropertyPOS){
                    if(actionPropertyPO.getPropertyId().equals(actionDefinitionPropertyPO.getPropertyId())){
                        if(actionDefinitionPropertyPO.getType() == 1) {
                            gainedProperties.put(propertyRepository.getPropertyById(actionPropertyPO.getPropertyId()),
                                    actionPropertyPO.getValue());
                        }else{
                            replacedProperties.put(propertyRepository.getPropertyById(actionPropertyPO.getPropertyId()),
                                    actionPropertyPO.getValue());
                        }
                    }
                }
            }

            ActionDefinitionPO actionDefinitionPO =
                    actionDefinitionMapper.selectOne(Wrappers.<ActionDefinitionPO>lambdaQuery().eq(
                            ActionDefinitionPO::getId, actionPO.getActionDefinitionId()
                    ));
            String argmentKeys = actionDefinitionPO.getArgumentKeys();
            String arguments = actionPO.getArguments();
            HashMap<String, String> argumentsMap = JSON.parseObject(arguments, HashMap.class);
            String actionDetail = getActionDetail(actionDefinitionPO.getPattern(),
                    argmentKeys.split(","),
                    argumentsMap);

            actions.add(new Action(actionDefinitionPO.getName(),
                    actionPO.getActionTime(),
                    gainedProperties,
                    replacedProperties,
                    actionDetail));
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

}
