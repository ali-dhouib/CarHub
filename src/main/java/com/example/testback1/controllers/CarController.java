package com.example.testback1.controllers;

import com.example.testback1.car.Car;
import com.example.testback1.car.CarServices;
import com.example.testback1.enums.FuelType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
//@Api(tags = "Car Management")
public class CarController {

    @Autowired
    private CarServices carService;

    @PostMapping
    //@ApiOperation(value = "Add a new car", notes = "Adds a new car.")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car createdCar = carService.addCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/picture")
    //@ApiOperation(value = "Update car picture", notes = "Updates the picture of a car.")
    public ResponseEntity<Void> updateCarPicture(@PathVariable Long id, @RequestParam("picture") String picture) {
        boolean success = carService.updateCarPicture(id, picture);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    //@ApiOperation(value = "Find cars by fuel type and max price", notes = "Finds cars by fuel type and maximum price.")
    public ResponseEntity<List<Car>> findCarsByFuelTypeAndMaxPrice(@RequestParam("fuelType") FuelType fuelType, @RequestParam("maxPrice") double maxPrice) {
        List<Car> cars = carService.findCarsByFuelTypeAndMaxPrice(fuelType, maxPrice);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

}
