package com.example.Floristeriaspringboot.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table (name = "tbl_flor")
public class FlorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private long id;
    private String nombre;
    private String tipo;
    private Double precio;
    private String color;
}