package com.kirill.microservice.service;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.repo.CarRepo;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car create(String brand) {
        Car car = new Car();
        car.setBrand(brand);

        return carRepo.save(car);
    }

    public Car get(Long id) {
        return carRepo.findById(id).get();
    }

    public Car update(Long id, Car car) {
        car.setId(id);
        return carRepo.save(car);
    }

    public void delete(Long id) {
        carRepo.deleteById(id);
    }

    public void delete(Car car) {
        carRepo.delete(car);
    }
}
