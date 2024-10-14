package com.example.Floristeriaspringboot.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "tbl_flor")

public class FlorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private long id;

    private String nombre;
    private String tipo;
    private Double precio;
    private String color;
    private String variedad; 
    private Double precioCompra;
    private Double precioVenta;
    private int stock;  
}



