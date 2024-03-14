package com.example.testback1.car;

import com.example.testback1.enums.FuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CarServices {

    @Autowired
    private CarRepository carRepository;


    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> findCarsByFuelTypeAndMaxPrice(FuelType fuelType, double maxPrice) {
        return carRepository.findCarsByFuelTypeAndMaxPrice(fuelType, maxPrice);
    }

    public boolean updateCarPicture(Long carId, String picture) {
        return carRepository.updateCarPicture(carId, picture);
    }


    public List<Car> getAllCars() {
        return StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
