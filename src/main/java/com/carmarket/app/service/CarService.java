package com.carmarket.app.service;

import com.carmarket.app.dto.CarDto;
import com.carmarket.app.model.Car;
import com.carmarket.app.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarService {

    private final CarRepository carRepository;
    private final Pageable pageable;

    public List<CarDto> findAllCars() {
        return carRepository.findAll(pageable)
                .stream()
                .map(entity -> CarDto.builder()
                        .description(entity.getDescription())
                        .price(entity.getPrice())
                        .model(entity.getModel())
                        .build())
                .collect(Collectors.toList());
    }

}
