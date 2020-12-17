package com.kirill.microservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kirill.microservice.entity.Car;
import com.kirill.microservice.entity.User;
import com.kirill.microservice.entity.Views;
import com.kirill.microservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @JsonView(Views.Full.class)
    @GetMapping("{id}")
    public User get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @JsonView(Views.IdName.class)
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        userService.delete(user.getId());
    }

    @PostMapping("{id}")
    public User addCar(@PathVariable("id") User user, @RequestBody Car car) {
        return userService.addCar(user, car);
    }

    @DeleteMapping("{id}")
    public User deleteCar(@PathVariable("id") User user, @RequestBody Car car) {
        return userService.addCar(user, car);
    }
}
