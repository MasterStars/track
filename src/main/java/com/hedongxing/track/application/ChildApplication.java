package com.hedongxing.track.application;

import com.hedongxing.track.achievement.infrastructure.persistence.ChildRepositoryImpl;
import com.hedongxing.track.achievement.model.Child;
import com.hedongxing.track.action.model.Action;
import com.hedongxing.track.action.model.DrinkMilk;
import com.hedongxing.track.action.model.Sleep;
import com.hedongxing.track.infrastructure.dto.SaveChildDTO;
import com.hedongxing.track.infrastructure.mapper.ChildMapper;
import com.hedongxing.track.infrastructure.po.ChildPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
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
        Child child = childRepository.getChildById(childId);
        Action drinkMilk = new DrinkMilk(time, milliliters);
        child.complete(drinkMilk);
    }

    public void sleep(String childId, LocalDateTime sleepTime, LocalDateTime wakeTime){
        Child child = childRepository.getChildById(childId);
        Action sleep = new Sleep(sleepTime, wakeTime);
        child.complete(sleep);
    }

    public String achievements(String childId) {
        Child child = childRepository.getChildById(childId);
        return child.printAccomplishedAchievements();
    }

    public String outputActions(String childId) {
        Child child = childRepository.getChildById(childId);
        return child.printActionDetails();
    }

}
