package com.kirill.microservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirill.microservice.entity.Car;
import com.kirill.microservice.entity.User;
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

    @Test
    public void givenBidirectionRelation_whenUsingJsonIdentityInfo_thenCorrect()
            throws JsonProcessingException {

        User user = new User();
        user.setId(1L);
        user.setName("John");

        Car car = new Car();
        car.setId(1L);
        car.setBrand("AAA");

        user.addCar(car);
        car.addUser(user);

        String result = new ObjectMapper().writeValueAsString(car);

        System.out.println(result);
    }

    @Test
    public void givenBidirectionRelation() throws JsonProcessingException {

        Car car = carService.get((long) 4);

        System.out.println("--------------------------------------");

        String result = new ObjectMapper().writeValueAsString(car);

        System.out.println(result);

    }
}
