package com.hedongxing.track.controller;

import com.hedongxing.track.application.ChildApplication;
import com.hedongxing.track.dto.SleepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/child")
@RequiredArgsConstructor
public class ChildController {

    private final ChildApplication childApplication;

    @PostMapping("/sleep")
    public String sleep(@RequestBody SleepDTO sleepDTO) {
        childApplication.sleep(sleepDTO.getSleepTime(), sleepDTO.getWakeTime());
        return "宝宝进入睡眠...";
    }

    @GetMapping("/achievements")
    public String achievements() {
        return childApplication.achievements();
    }

    @GetMapping("/actions")
    public String actions() {
        return childApplication.actions();
    }
}
