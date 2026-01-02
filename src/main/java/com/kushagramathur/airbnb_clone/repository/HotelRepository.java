package com.kushagramathur.airbnb_clone.repository;

import com.kushagramathur.airbnb_clone.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
