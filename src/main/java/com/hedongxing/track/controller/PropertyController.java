package com.hedongxing.track.controller;

import com.hedongxing.track.application.PropertyApplication;
import com.hedongxing.track.infrastructure.dto.SavePropertyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyApplication propertyApplication;

    @PostMapping
    public String addProperty(@RequestBody SavePropertyDTO savePropertyDTO) {
        propertyApplication.addProperty(savePropertyDTO);
        return "添加属性成功!";
    }


}
