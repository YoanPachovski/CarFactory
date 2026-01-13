package com.example.springboot.data.models.dto;

import com.example.springboot.data.models.entities.BaseEntity;
import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CarDto {
    private long id;
    private String model;
    private String registrationNumber;
    private double price;
    private String brand;
}
