package com.kushagramathur.airbnb_clone.repository;

import com.kushagramathur.airbnb_clone.entity.Inventory;
import com.kushagramathur.airbnb_clone.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);

}
