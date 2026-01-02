package com.kushagramathur.airbnb_clone.dto;

import com.kushagramathur.airbnb_clone.entity.HotelContactInfo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private Boolean active;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
}
