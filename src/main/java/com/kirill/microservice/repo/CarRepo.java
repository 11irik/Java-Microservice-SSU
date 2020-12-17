package com.kirill.microservice.repo;

import com.kirill.microservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {

    @Query(value = "select * from car inner join usr_cars uc on car.id = uc.cars_id inner join usr u on uc.users_id = u.id where name = ?1", nativeQuery = true)
    List<Car> custom(String name);
}
