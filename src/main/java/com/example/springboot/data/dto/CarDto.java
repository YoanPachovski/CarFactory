package com.example.springboot.data.dto;

import com.example.springboot.data.entities.BaseEntity;


public class CarDto extends BaseEntity {
    private long id;
    private String model;
    private String registrationNumber;
    private double price;
}
