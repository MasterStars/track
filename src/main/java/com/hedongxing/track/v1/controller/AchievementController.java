package com.hedongxing.track.v1.controller;

import com.hedongxing.track.v1.application.AchievementApplication;
import com.hedongxing.track.v1.infrastructure.dto.SaveAchievementDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementApplication achievementApplication;

    @PostMapping
    public String addAchievement(@RequestBody SaveAchievementDTO saveAchievementDTO) {
        achievementApplication.addAchievement(saveAchievementDTO);
        return "添加成就成功!";
    }
}
