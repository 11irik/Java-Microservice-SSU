package com.kirill.microservice.controller;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.service.CarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.create(car.getBrand());
    }

    @GetMapping("{id}")
    public Car get(@PathVariable("id") Long id) {
        return carService.get(id);
    }

    @PutMapping("{id}")
    public Car update(@PathVariable("id") Long id, @RequestBody Car car) {
        return carService.update(id, car);
    }

    @DeleteMapping
    public void delete(@RequestBody Car car) {
        carService.delete(car.getId());
    }
}
