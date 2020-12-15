package com.scotia.challenge.car.service;

import com.scotia.challenge.car.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.scotia.challenge.car.repository.CarRepository;

@Service
@Lazy
public class CarServiceHandler implements CarService {

    @Autowired
    CarRepository repository;

    @Override
    public Car save(Car model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(Car::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Car model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
