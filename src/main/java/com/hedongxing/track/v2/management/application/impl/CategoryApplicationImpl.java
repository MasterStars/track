package com.hedongxing.track.v2.management.application.impl;

import com.hedongxing.track.v2.infrastructure.mapper.CategoryMapper;
import com.hedongxing.track.v2.infrastructure.po.CategoryPO;
import com.hedongxing.track.v2.management.application.CategoryApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryApplicationImpl implements CategoryApplication {

    private final CategoryMapper categoryMapper;

    @Override
    public void addCategory(String kitSerialNumber, String parentId, String name) {
        CategoryPO categoryPO = new CategoryPO();
        categoryPO.setId(UUID.randomUUID().toString());
        categoryPO.setKitSerialNumber(kitSerialNumber);
        categoryPO.setParentId(parentId);
        categoryPO.setName(name);
        categoryMapper.insert(categoryPO);
    }

    @Override
    public void editCategory(String categoryId, String parentId, String name) {
        CategoryPO categoryPO = categoryMapper.selectById(categoryId);
        categoryPO.setParentId(parentId);
        categoryPO.setName(name);
        categoryMapper.updateById(categoryPO);
    }
}
