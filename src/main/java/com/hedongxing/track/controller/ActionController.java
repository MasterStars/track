package com.hedongxing.track.controller;

import com.hedongxing.track.application.ActionApplication;
import com.hedongxing.track.infrastructure.dto.SaveActionDefinitionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actions")
@RequiredArgsConstructor
public class ActionController {

    private final ActionApplication actionApplication;

    @PostMapping
    public String addAction(@RequestBody SaveActionDefinitionDTO saveActionDefinitionDTO) {
        actionApplication.addActionDefinition(saveActionDefinitionDTO);
        return "添加动作成功!";
    }
}
