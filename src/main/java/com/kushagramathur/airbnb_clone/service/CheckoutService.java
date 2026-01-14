package com.kushagramathur.airbnb_clone.service;

import com.kushagramathur.airbnb_clone.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);

}
