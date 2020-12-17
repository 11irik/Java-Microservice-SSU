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
            Car newCar = new Car();
            newCar.setBrand(car.getBrand());
            return carRepo.save(newCar);
        }
    }

    public Car get(Long id) {
        Car found = carRepo.getOne(id);
        found.getUsers();
        return found;
    }

    public List<Car> getAll() {
        return carRepo.findAll();
    }

    public Car update(Long id, Car car) {
        Car found = carRepo.getOne(id);
        found.setBrand(car.getBrand());
        return carRepo.save(found);
    }

    public void delete(Long id) {
        carRepo.deleteById(id);
    }

    public void delete(Car car) {
        carRepo.delete(car);
    }
}
