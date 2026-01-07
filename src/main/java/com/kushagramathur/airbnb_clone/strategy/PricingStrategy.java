package com.kushagramathur.airbnb_clone.strategy;

import com.kushagramathur.airbnb_clone.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);

}
