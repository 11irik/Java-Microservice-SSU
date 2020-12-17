package com.kirill.microservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kirill.microservice.entity.Car;
import com.kirill.microservice.entity.Views;
import com.kirill.microservice.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @JsonView(Views.IdName.class)
    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @JsonView(Views.Full.class)
    @GetMapping("{id}")
    public Car get(@PathVariable("id") Long id) {
        return carService.get(id);
    }

    @JsonView(Views.IdName.class)
    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @JsonView(Views.IdName.class)
    @PutMapping("{id}")
    public Car update(@PathVariable("id") Long id, @RequestBody Car car) {
        return carService.update(id, car);
    }

    @DeleteMapping
    public void delete(@RequestBody Car car) {
        carService.delete(car.getId());
    }

    @JsonView(Views.Full.class)
    @GetMapping("custom")
    public List<Car> customReq() {
        return carService.customReq("abc");
    }
}
