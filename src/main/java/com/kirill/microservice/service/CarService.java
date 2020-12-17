package com.kirill.microservice.service;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.repo.CarRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car create(Car car) {
        if (car.getBrand() == null || "".equals(car.getBrand())) {
            throw new IllegalArgumentException();
        } else {
            return carRepo.save(car);
        }
    }

    public Car get(Long id) {
        return carRepo.findById(id).get();
    }

    public List<Car> getAll() {
        return carRepo.findAll();
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
