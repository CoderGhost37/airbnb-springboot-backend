package com.kushagramathur.airbnb_clone.service;

import com.kushagramathur.airbnb_clone.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventory(Room room);

}
