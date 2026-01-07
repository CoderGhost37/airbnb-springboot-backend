package com.kushagramathur.airbnb_clone.dto;

import com.kushagramathur.airbnb_clone.entity.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDto {
    private Long id;
    private Integer roomCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;
    private LocalDateTime createdAt;
}
