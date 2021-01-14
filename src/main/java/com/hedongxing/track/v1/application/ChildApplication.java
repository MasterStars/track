package com.hedongxing.track.v1.application;

import com.hedongxing.track.v1.achievement.infrastructure.persistence.ChildRepositoryImpl;
import com.hedongxing.track.v1.achievement.model.AccomplishedAchievement;
import com.hedongxing.track.v1.achievement.model.Action;
import com.hedongxing.track.v1.achievement.model.ActionRepository;
import com.hedongxing.track.v1.achievement.model.Child;
import com.hedongxing.track.v1.achievement.model.action.Sleep;
import com.hedongxing.track.v1.infrastructure.dto.SaveChildDTO;
import com.hedongxing.track.v1.infrastructure.mapper.ChildMapper;
import com.hedongxing.track.v1.infrastructure.po.ChildPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChildApplication {

    private final ChildRepositoryImpl childRepository;

    private final ChildMapper childMapper;

    public void saveChildPO(String childId, SaveChildDTO saveChildDTO) {
        ChildPO childPO = new ChildPO();
        String id = childId;
        if(!StringUtils.hasLength(id)) {
            id = UUID.randomUUID().toString();
        }
        childPO.setId(id);
        childPO.setName(saveChildDTO.getName());
        childPO.setAge(saveChildDTO.getAge());
        childPO.setSex(saveChildDTO.getSex());
        childMapper.insert(childPO);
    }

    public void drinkMilk(String childId, LocalDateTime time, Integer milliliters) {

    }

    public void sleep(String childId, LocalDateTime sleepTime, LocalDateTime wakeTime){
        Child child = childRepository.getChildById(childId);
        Sleep sleep = new Sleep(sleepTime, wakeTime);
        child.complete(sleep.toAction());

    }

    public String achievements(String childId) {
        Child child = childRepository.getChildById(childId);
        String accomplishedAchievementsPrinter = child.getName() + "成就榜: " + "\n";
        int points = 0;
        for(AccomplishedAchievement accomplishedAchievement : child.getAccomplishedAchievements()) {
            accomplishedAchievementsPrinter += accomplishedAchievement.getAchievement().getName() + ": " + accomplishedAchievement.getAchievement().getScore() + "\n";
            points += accomplishedAchievement.getAchievement().getScore();
        }
        accomplishedAchievementsPrinter += "当前成就分: " + points;
        return accomplishedAchievementsPrinter;
    }

    public String outputActions(String childId) {
        List<Action> actionRecords = ActionRepository.getChildActionRecords(childId);
        StringBuilder details = new StringBuilder();
        for(Action action : actionRecords) {
            details.append("完成<" + action.getActionWord() + ">,详细: " + action.getDetail());
            details.append("\n");
        }
        return details.toString();
    }

}
