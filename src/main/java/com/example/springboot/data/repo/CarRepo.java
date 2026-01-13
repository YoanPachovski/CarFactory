package com.example.springboot.data.repo;

import com.example.springboot.data.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {

    @Override
    Car getById(Long aLong);

    List<Car> findCarsByBrand(String brand);
}