package com.kushagramathur.airbnb_clone.service;

import com.kushagramathur.airbnb_clone.dto.BookingDto;
import com.kushagramathur.airbnb_clone.dto.BookingRequestDto;
import com.kushagramathur.airbnb_clone.dto.GuestDto;

import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequestDto bookingRequestDto);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
