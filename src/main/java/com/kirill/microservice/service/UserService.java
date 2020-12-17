package com.kirill.microservice.service;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.entity.User;
import com.kirill.microservice.repo.CarRepo;
import com.kirill.microservice.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;

    private final CarRepo carRepo;

    public UserService(UserRepo userRepo, CarRepo carRepo) {
        this.userRepo = userRepo;
        this.carRepo = carRepo;
    }

    public User create(User user) {
        if (user.getName() == null || "".equals(user.getName())) {
            throw new IllegalArgumentException();
        } else {
            return userRepo.save(user);
        }
    }

    public User get(Long id) {
        User found = userRepo.findById(id).get();
        found.getCars();
        return found;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User update(Long id, User user) {
        user.setId(id);
        return userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public User addCar(User user, Car car) {
        Car found = carRepo.getOne(car.getId());
        user.addCar(found);
        return userRepo.save(user);
    }

    public User deleteCar(User user, Car car) {
        user.deleteCar(car);
        return userRepo.save(user);
    }

}
