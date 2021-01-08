package com.hedongxing.track.achievement.infrastructure.persistence;

import com.hedongxing.track.achievement.model.Action;
import com.hedongxing.track.infrastructure.mapper.ActionMapper;
import com.hedongxing.track.infrastructure.mapper.ChildActionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ActionRepositoryImpl {

    private final ActionMapper actionMapper;

    private final ChildActionMapper childActionMapper;

    public List<Action> getChildActions(String childId) {
        return new ArrayList<>();
    }

}
