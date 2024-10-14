package com.example.Floristeriaspringboot.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_cliente", nullable = false)
    private String clienteNombre; // Nombre del cliente que realiza el pedido

    @Column(name = "direccion", nullable = false)
    private String direccion; // Dirección de entrega

    @Column(name = "contacto", nullable = false)
    private String contacto; // Información de contacto del cliente

    @Column(name = "tipo_arreglo", nullable = false)
    private String tipoArreglo; // Tipo de arreglo floral

    @Column(name = "ocasion", nullable = false)
    private String ocasion; // Ocasión para la que se realiza el pedido

    @Column(name = "fecha_entrega", nullable = false)
    private String fechaEntrega; // Fecha de entrega del pedido

    @Column(name = "presupuesto", nullable = false)
    private double presupuesto; // Presupuesto del cliente

    @Column(name = "estado", nullable = false)
    private String estado; // Estado del pedido (en curso, completado, entregado)

    @Column(name = "tipo_flor", nullable = false)
    private String tipoFlor; // Tipo de flor o flor asociada al pedido

    @Column(name = "cantidad", nullable = false)
    private int cantidad; // Cantidad de flores en el pedido

    // Métodos getter y setter son generados por Lombok gracias a la anotación @Data

}
