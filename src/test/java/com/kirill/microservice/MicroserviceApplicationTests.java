package com.kirill.microservice;

import com.kirill.microservice.service.CarService;
import com.kirill.microservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroserviceApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Test
    void contextLoads() {
    }
}
