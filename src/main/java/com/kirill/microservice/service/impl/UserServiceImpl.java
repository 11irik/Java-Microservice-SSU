package com.kirill.microservice.service.impl;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.entity.User;
import com.kirill.microservice.repo.CarRepo;
import com.kirill.microservice.repo.UserRepo;
import com.kirill.microservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final CarRepo carRepo;

    public UserServiceImpl(UserRepo userRepo, CarRepo carRepo) {
        this.userRepo = userRepo;
        this.carRepo = carRepo;
    }

    @Override
    public User create(User user) {
        if (user.getName() == null || "".equals(user.getName())) {
            throw new IllegalArgumentException();
        } else {
            User newUser = new User();
            newUser.setName(user.getName());
            return userRepo.save(newUser);
        }
    }

    @Override
    public User get(Long id) {
        User found = userRepo.findById(id).get();
        found.getCars();
        return found;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User update(Long id, User user) {
        if (user.getName() == null || "".equals(user.getName())) {
            throw new IllegalArgumentException();
        } else {
            User found = userRepo.getOne(id);
            found.setName(user.getName());
            return found;
        }
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public User addCar(User user, Car car) {
        Car foundCar = carRepo.getOne(car.getId());
        user.addCar(foundCar);
        return user;
    }

    @Override
    public User deleteCar(User user, Car car) {
        Car foundCar = carRepo.getOne(car.getId());
        user.deleteCar(foundCar);
        return user;
    }

}
