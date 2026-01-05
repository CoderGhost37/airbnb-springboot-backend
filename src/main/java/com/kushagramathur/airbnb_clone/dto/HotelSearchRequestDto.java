package com.kushagramathur.airbnb_clone.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HotelSearchRequestDto {
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer roomsCount;

    private Integer page = 0;
    private Integer size = 10;
}
