package com.kushagramathur.airbnb_clone.repository;

import com.kushagramathur.airbnb_clone.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRespository extends JpaRepository<Booking, Long> {
}
