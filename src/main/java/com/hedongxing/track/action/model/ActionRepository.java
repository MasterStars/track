package com.hedongxing.track.action.model;

import java.util.*;

public class ActionRepository {

    private static Map<String, List<Action>> actionMap = new HashMap<>();

    private static List<Action> sortedActions = new LinkedList<>();

    public static List<Action> findActionRecordsOf(String actionName) {
        return actionMap.get(actionName);
    }

    public static List<Action> allActions() {
        return sortedActions;
    }

    public static void save(Action action) {
        sortedActions.add(action);

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
