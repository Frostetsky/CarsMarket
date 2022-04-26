package com.carmarket.app.service;

import com.carmarket.app.model.Car;
import com.carmarket.app.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }
}
