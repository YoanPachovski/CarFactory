package com.example.springboot.controller;

import com.example.springboot.data.models.dto.CarDto;
import com.example.springboot.data.models.dto.CreateCarDto;
import com.example.springboot.data.models.entities.Car;
import com.example.springboot.service.CarService;
import com.example.springboot.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final MapperUtil mapperUtil;

    @PostMapping("/create")
    public CreateCarDto createCar(@RequestBody CreateCarDto carDto) {
        Car Car = new Car();
        Car.setRegistrationNumber(carDto.getRegistrationNumber());
        Car.setPrice(carDto.getPrice());
        Car.setModel(carDto.getModel());
        Car.setBrand(carDto.getBrand());

        // Convert and return response as DTO
        return carService.createCarDto(Car);
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable long id){
        return this.carService.getCar(id);
    }

    @GetMapping("/all")
    public List<CarDto> getAllCars() {
        return this.carService.getAllCars();
    }

    @PutMapping("/update/{id}")
    public CarDto updateCar(@PathVariable long id, @RequestBody Car CarDto) {
        return this.mapperUtil.getModelMapper()
            .map(this.carService.updateCar(CarDto, id), CarDto.class);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable long id) {
        this.carService.deleteCar(id);
    }

    @GetMapping("/by-brand/{brand}")
    public List<CarDto> getCarsByBrand(@PathVariable String brand) {
        return this.carService.getCarsByBrand(brand);
    }
}
