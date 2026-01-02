package com.kushagramathur.airbnb_clone.service.impl;

import com.kushagramathur.airbnb_clone.dto.RoomDto;
import com.kushagramathur.airbnb_clone.entity.Hotel;
import com.kushagramathur.airbnb_clone.entity.Room;
import com.kushagramathur.airbnb_clone.exception.ResourceNotFoundException;
import com.kushagramathur.airbnb_clone.repository.HotelRepository;
import com.kushagramathur.airbnb_clone.repository.InventoryRepository;
import com.kushagramathur.airbnb_clone.repository.RoomRepository;
import com.kushagramathur.airbnb_clone.service.InventoryService;
import com.kushagramathur.airbnb_clone.service.RoomService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;

    @Override
    public RoomDto createRoom(Long hotelId, RoomDto roomDto) {
        log.info("Creating room with hotelId {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));

        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);

        room = roomRepository.save(room);
        if (hotel.getActive()) {
            inventoryService.initializeRoomForAYear(room);
        }

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting hotel with hotelId {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));


        return hotel.getRooms()
                .stream()
                .map(element -> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long id) {
        log.info("Getting room with id {}", id);
        Room room = roomRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + id + " not found"));
        return null;
    }

    @Override
    @Transactional
    public void deleteRoomById(Long id) {
        log.info("Deleting room with id {}", id);
        Room room = roomRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + id + " not found"));

        inventoryService.deleteFutureInventory(room);
        roomRepository.deleteById(id);
    }
}
