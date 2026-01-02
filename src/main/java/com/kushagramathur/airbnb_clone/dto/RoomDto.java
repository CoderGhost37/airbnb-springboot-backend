package com.kushagramathur.airbnb_clone.dto;

import com.kushagramathur.airbnb_clone.entity.Hotel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDto {
    private Long id;
    private String type;
    private BigDecimal basePrice;
    private String[] photos;
    private String[] amenities;
    private Integer totalCount;
    private Integer capacity;
}
