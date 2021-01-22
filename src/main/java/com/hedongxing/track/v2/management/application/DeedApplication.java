package com.hedongxing.track.v2.management.application;

import com.hedongxing.track.v2.management.infrastructure.dto.EditDeedDTO;

public interface DeedApplication {

    void addDeed(String kitSerialNumber, String categoryId, String name, String description);

    void editDeed(String deedId, EditDeedDTO editDeedDTO);

    void deleteDeed(String deedId);
}
