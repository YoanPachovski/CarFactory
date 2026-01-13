package com.example.springboot.data.models.dto;

import com.example.springboot.data.models.entities.BaseEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CreateCarDto {
    private String model;
    private String registrationNumber;
    private double price;
    private String brand;
}
