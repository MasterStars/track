package com.hedongxing.track.v1.controller;

import com.hedongxing.track.v1.application.ChildApplication;
import com.hedongxing.track.v1.infrastructure.dto.SaveChildDTO;
import com.hedongxing.track.v1.infrastructure.dto.SleepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildApplication childApplication;

    @PostMapping
    public String addChild(@RequestBody SaveChildDTO saveChildDTO) {
        childApplication.saveChildPO(null, saveChildDTO);
        return "添加child完成";
    }

    @PutMapping("/{childId}")
    public String updateChild(@PathVariable String childId, @RequestBody SaveChildDTO saveChildDTO) {
        childApplication.saveChildPO(childId, saveChildDTO);
        return "更新child完成";
    }

    @PostMapping("/{childId}/sleep")
    public String sleep(@PathVariable String childId, @RequestBody SleepDTO sleepDTO) {
        childApplication.sleep(childId, sleepDTO.getSleepTime(), sleepDTO.getWakeTime());
        return "宝宝进入睡眠...";
    }

    @GetMapping("/{childId}/achievements")
    public String achievements(@PathVariable String childId) {
        return childApplication.achievements(childId);
    }

    @GetMapping("/{childId}/actions")
    public String actions(@PathVariable String childId) {
        return childApplication.outputActions(childId);
    }
}
