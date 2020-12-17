package com.kirill.microservice.service.impl;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.repo.CarRepo;
import com.kirill.microservice.service.CarService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;

    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public Car create(Car car) {
        if (car.getBrand() == null || "".equals(car.getBrand())) {
            throw new IllegalArgumentException();
        } else {
            Car newCar = new Car();
            newCar.setBrand(car.getBrand());
            return carRepo.save(newCar);
        }
    }

    @Override
    public Car get(Long id) {
        Car found = carRepo.getOne(id);
        found.getUsers();
        return found;
    }

    @Override
    public List<Car> getAll() {
        return carRepo.findAll();
    }

    @Override
    public Car update(Long id, Car car) {
        Car found = carRepo.getOne(id);
        found.setBrand(car.getBrand());
        return carRepo.save(found);
    }

    @Override
    public void delete(Long id) {
        carRepo.deleteById(id);
    }

    @Override
    public void delete(Car car) {
        carRepo.delete(car);
    }
}
