package com.kirill.microservice.controller;

import com.kirill.microservice.entity.Car;
import com.kirill.microservice.entity.User;
import com.kirill.microservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user.getName());
    }

    @GetMapping("{id}")
    public User get(@PathVariable("id") Long id) {
        return userService.get(id);
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
}
