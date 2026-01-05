package com.kushagramathur.airbnb_clone.controller;

import com.kushagramathur.airbnb_clone.dto.HotelDto;
import com.kushagramathur.airbnb_clone.dto.HotelInfoDto;
import com.kushagramathur.airbnb_clone.dto.HotelSearchRequestDto;
import com.kushagramathur.airbnb_clone.service.HotelService;
import com.kushagramathur.airbnb_clone.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotels(@RequestBody HotelSearchRequestDto hotelSearchRequest) {
        Page<HotelDto> page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }

}
