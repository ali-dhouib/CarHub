package com.example.testback1.car;

import com.example.testback1.enums.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c WHERE c.fuelType = ?1 AND c.price >= ?2")
    List<Car> findCarsByFuelTypeAndMaxPrice (FuelType fuelType , double maxPrice);

    @Modifying
    @Transactional
    @Query("UPDATE Car c SET c.picture = ?2 WHERE c.id = ?1")
    boolean updateCarPicture (Long carId , String picture);
}
