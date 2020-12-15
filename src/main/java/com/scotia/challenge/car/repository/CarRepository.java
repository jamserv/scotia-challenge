package com.scotia.challenge.car.repository;

import com.scotia.challenge.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
