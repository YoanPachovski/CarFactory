package com.example.springboot.data.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "car")
@Entity
public class Car extends BaseEntity {
    @Column (name = "model")
    private String model;
    @Column (name = "registration_number", unique = true)
    private String registrationNumber;
    @Column (name = "price")
    private double price;
    @Column (name = "brand")
    private String brand;
}
