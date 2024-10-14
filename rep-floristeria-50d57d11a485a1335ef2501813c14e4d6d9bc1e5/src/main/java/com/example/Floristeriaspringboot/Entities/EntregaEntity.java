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
@Table(name = "entregas")

public class EntregaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedidoId; // Relación con Pedido
    private String conductor; // Nombre del conductor
    private String direccion; // Dirección de entrega
    private String fechaEntrega; // Fecha de entrega.
    private String estado; // en camino, entregado, etc.

    // Getters y Setters
    // ...
}
    

