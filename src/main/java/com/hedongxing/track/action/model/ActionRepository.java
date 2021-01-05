package com.hedongxing.track.action.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionRepository {

    private static Map<String, List<Action>> actionMap = new HashMap<>();

    public static List<Action> findActionRecordsOf(String actionName) {
        return actionMap.get(actionName);
    }

    public static void save(Action action) {
        List<Action> actions;
        if(actionMap.containsKey(action.getName())) {
            actions = actionMap.get(action.getName());
        }else{
            actions = new ArrayList<>();
        }

        actions.add(action);
        actionMap.put(action.getName(), actions);
    }
}
