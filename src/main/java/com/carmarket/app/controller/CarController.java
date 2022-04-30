package com.carmarket.app.controller;

import com.carmarket.app.dto.CarDto;
import com.carmarket.app.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Контроллер по работе с автомобилями.
 */
@RestController
@RequestMapping("/marketCars")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {

    private final CarService carService;

    /**
     * Отобразит все автомобили
     * @return список автомобилей
     */
    @GetMapping("/findAll")
    public List<CarDto> findAllCars() {
        return carService.findAllCars();
    }


    /**
     * Отобразит все автомобили данного модельного ряда
     * @param model модель автомобиля
     * @return список автомобилей
     */
    @GetMapping("/findAllByModel/{model}")
    public List<CarDto> findAllCarsByModel(@PathVariable("model") String model) {
        return List.of();
    }


    /**
     * Отобразит все автомобили в диапазоне цен.
     * Если не задан стартовый параметр, то берётся минимальный
     * Если не задан конечный параметр, то берется максимальный
     * Если не заданы оба, то выводится дефолтное количество
     * @param startPrice - начальная цена диапазона
     * @param endPrice - конечная цена диапазона
     * @return список автомобилей
     */
    @GetMapping("/findAllCarsBetweenPrices")
    public List<CarDto> findAllCarsBetweenPrices(@RequestParam(value = "startPrice", required = false) String startPrice,
                                                 @RequestParam(value = "endPrice", required = false) String endPrice) {

        return List.of();
    }

    /**
     * Отобразит все автомобили в отсортированном виде
     * @param criteria - если значение true, то сортировка происходит по возрастанию, false - по убыванию.
     * @return список автомобилей
     */
    @GetMapping("/findAllCarsByOrderBy/{criteria}")
    public List<CarDto> findAllCarsByOrderBy(@PathVariable("criteria") Boolean criteria) {

        return List.of();
    }
}
