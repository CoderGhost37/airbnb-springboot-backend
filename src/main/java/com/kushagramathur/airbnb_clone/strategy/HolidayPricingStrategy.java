package com.kushagramathur.airbnb_clone.strategy;

import com.kushagramathur.airbnb_clone.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class HolidayPricingStrategy implements PricingStrategy {

    private final PricingStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = wrapped.calculatePrice(inventory);

        boolean isTodayHoliday = true;  // call an API to check for holiday
        if (isTodayHoliday) {
            price = price.multiply(BigDecimal.valueOf(1.25));
        }

        return price;
    }
}
