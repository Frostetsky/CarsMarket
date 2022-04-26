package com.carmarket.app.controller;

import com.carmarket.app.model.Car;
import com.carmarket.app.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marketCars")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {

    private final CarService carService;

    @GetMapping("/findAll")
    public List<Car> findAllCars() {
        return carService.findAllCars();
    }
}
