package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.DeedMapper;
import com.hedongxing.track.v2.infrastructure.po.DeedPO;
import com.hedongxing.track.v2.management.application.DeedApplication;
import com.hedongxing.track.v2.management.infrastructure.dto.EditDeedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeedApplicationImpl implements DeedApplication {

    private final DeedMapper deedMapper;

    @Override
    public void addDeed(String kitSerialNumber, String categoryId, String name, String description) {
        DeedPO deedPO = new DeedPO();
        deedPO.setId(UUID.randomUUID().toString());
        deedPO.setKitSerialNumber(kitSerialNumber);
        deedPO.setCategoryId(categoryId);
        deedPO.setName(name);
        deedPO.setDescription(description);
        deedMapper.insert(deedPO);
    }

    @Override
    public void editDeed(String deedId, EditDeedDTO editDeedDTO) {
        DeedPO deedPO = deedMapper.selectById(deedId);
        deedPO.setCategoryId(editDeedDTO.getCategoryId());
        deedPO.setName(editDeedDTO.getName());
        deedPO.setDescription(editDeedDTO.getDescription());
        deedMapper.updateById(deedPO);
    }

    @Override
    public void deleteDeed(String deedId) {
        deedMapper.deleteById(deedId);
    }
}
