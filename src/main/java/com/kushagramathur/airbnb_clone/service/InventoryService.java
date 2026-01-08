package com.kushagramathur.airbnb_clone.service;

import com.kushagramathur.airbnb_clone.dto.HotelPriceDto;
import com.kushagramathur.airbnb_clone.dto.HotelSearchRequestDto;
import com.kushagramathur.airbnb_clone.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventory(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequestDto hotelSearchRequest);
}
