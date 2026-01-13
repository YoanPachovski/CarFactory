package com.example.springboot.data.models.dto;

import com.example.springboot.data.models.entities.BaseEntity;


public class CarDto extends BaseEntity {
    private long id;
    private String model;
    private String registrationNumber;
    private double price;
    private String brand;

}
