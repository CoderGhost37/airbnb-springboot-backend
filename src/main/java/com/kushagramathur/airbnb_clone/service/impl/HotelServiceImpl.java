package com.kushagramathur.airbnb_clone.service.impl;

import com.kushagramathur.airbnb_clone.dto.HotelDto;
import com.kushagramathur.airbnb_clone.entity.Hotel;
import com.kushagramathur.airbnb_clone.exception.ResourceNotFoundException;
import com.kushagramathur.airbnb_clone.repository.HotelRepository;
import com.kushagramathur.airbnb_clone.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating hotel with hotelDto: {}", hotelDto);
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);

        hotel =  hotelRepository.save(hotel);
        log.info("Hotel has been created: {}", hotel);

        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting hotel with hotelId: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + id + " not found"));
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating hotel with hotelDto: {}", hotelDto);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + id + " not found"));

        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        hotelRepository.save(hotel);

        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public Boolean deleteHotelById(Long id) {
        log.info("Deleting hotel with hotelId: {}", id);
        boolean exists = hotelRepository.existsById(id);
        if (!exists) throw new ResourceNotFoundException("Hotel with id " + id + " not found");

        hotelRepository.deleteById(id);
        // TODO: delete the future inventories for this hotel

        return true;
    }
}
