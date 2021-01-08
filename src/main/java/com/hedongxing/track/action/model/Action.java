package com.hedongxing.track.action.model;

import com.hedongxing.track.achievement.model.Child;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class Action implements Comparable<Action> {

    private String name;

    private LocalDateTime actionTime;

    public Action(String name, LocalDateTime actionTime) {
        this.name = name;
        this.actionTime = actionTime;
    }

    /**
     * 动作执行
     * @param child
     */
    public abstract void execute(Child child);

    /**
     * 打印动作详情
     * @return
     */
    public abstract String printDetail();

    @Override
    public int compareTo(Action o) {
        if(getActionTime().isBefore(o.getActionTime())) {
            return -1;
        }else{
            return 1;
        }
    }
}
