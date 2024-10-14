package com.example.Floristeriaspringboot.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_facturas")

public class FacturaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idPedido; // ID del pedido asociado a la factura
    private String nombreCliente; // Nombre del cliente
    private double total; // Monto total de la factura
    private Date fecha; // Fecha de emisión de la factura
    private String estadoPago; // Estado del pago (pagado, pendiente, etc.)

    // Aquí puedes agregar otros campos según sea necesario
}
