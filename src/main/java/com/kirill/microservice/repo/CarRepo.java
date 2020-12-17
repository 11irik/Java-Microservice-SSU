package com.kirill.microservice.repo;

import com.kirill.microservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}
