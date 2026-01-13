package com.example.springboot.service;

import com.example.springboot.data.models.dto.CreateCarDto;
import com.example.springboot.data.models.dto.CarDto;
import com.example.springboot.data.models.entities.Car;
import com.example.springboot.data.repo.CarRepo;
import com.example.springboot.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final MapperUtil mapperUtil;
    private final CarRepo CarRepo;

    public CarService(MapperUtil mapperUtil, CarRepo carRepo) {
        this.mapperUtil = mapperUtil;
        this.CarRepo = carRepo;
    }

    public CreateCarDto createCarDto(Car Car) {
        return mapperUtil.getModelMapper()
                .map(this.CarRepo
                        .save(mapperUtil.getModelMapper()
                                .map(Car, Car.class)), CreateCarDto.class);

    }

    public CarDto getCar(long id) {
        return this.mapperUtil.getModelMapper()
                .map(this.CarRepo.getById(id),
                        CarDto.class);
    }

    public List<CarDto> getAllCars() {
        return this.mapperUtil
                .mapList(
                        this.CarRepo.findAll(), CarDto.class);
    }

    public Car updateCar(Car Car, long id) {
//        Car == json Entity
//        Car1 == db Entity
//        if Car1.field == null, then Car.field = Car.field
        return this.CarRepo.findById(id)
                .map(Car1 -> {
                    Car1.setBrand(Car.getBrand() == null ? Car1.getBrand() : Car.getBrand());
                    Car1.setPrice(Car.getPrice() == 0.0 ? Car1.getPrice() : Car.getPrice());
                    Car1.setModel(Car.getModel() == null ? Car1.getModel() : Car.getModel());
                    Car1.setRegistrationNumber(Car.getRegistrationNumber() == null ? Car1.getRegistrationNumber() : Car.getRegistrationNumber());
                    return this.CarRepo.save(Car1);
                })                .orElseThrow(() -> new RuntimeException("Car with id=" + id + " not found!"));
    }

    public void deleteCar(long id) {
        this.CarRepo.deleteById(id);
    }

    public List<CarDto> getCarsByBrand(String brand) {
        return this.mapperUtil
                .mapList(
                        this.CarRepo.findCarsByBrand(brand), CarDto.class);
    }

}
