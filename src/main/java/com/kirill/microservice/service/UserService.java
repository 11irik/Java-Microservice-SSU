package com.kirill.microservice.service;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User get(Long id);

    List<User> getAll();

    User update(Long id, User user);

    void delete(Long id);

    void delete(User user);

    User addCar(User user, Car car);

    User deleteCar(User user, Car car);
}
