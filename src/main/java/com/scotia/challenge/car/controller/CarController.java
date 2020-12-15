package com.scotia.challenge.car.controller;

import com.scotia.challenge.api.commons.Constants;
import com.scotia.challenge.api.commons.ControllerBase;
import com.scotia.challenge.car.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scotia.challenge.car.service.CarService;

@RestController
@RequestMapping(Constants.URI_CAR)
@Lazy
@CrossOrigin
public class CarController extends ControllerBase<Car> {

    @Autowired
    public CarController(CarService service) {
        super(service);
    }
}
