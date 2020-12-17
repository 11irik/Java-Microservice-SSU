package com.kirill.microservice.service;

import com.kirill.microservice.entity.User;
import com.kirill.microservice.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User create(String name) {
        User user = new User();
        user.setName(name);

        return userRepo.save(user);
    }

    public User get(Long id) {
        return userRepo.findById(id).get();
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

}
