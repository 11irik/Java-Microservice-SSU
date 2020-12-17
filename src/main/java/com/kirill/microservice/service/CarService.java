package com.kirill.microservice.service;

import com.kirill.microservice.entity.Car;

import java.util.List;

public interface CarService {
    Car create(Car car);

    Car get(Long id);

    List<Car> getAll();

    Car update(Long id, Car car);

    void delete(Long id);

    void delete(Car car);

    List<Car> customReq(String name);
}
