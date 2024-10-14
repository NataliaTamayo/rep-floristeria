package com.example.Floristeriaspringboot.Service;

import com.example.Floristeriaspringboot.Entities.PedidoEntity;
import com.example.Floristeriaspringboot.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoEntity> findAll() {
        return pedidoRepository.findAll();
    }

    public PedidoEntity addPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    // Puedes agregar métodos adicionales aquí si es necesario
    public PedidoEntity findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
    
    public PedidoEntity updatePedido(Long id, PedidoEntity pedidoDetails) {
        PedidoEntity pedido = findById(id);
        pedido.setClienteNombre(pedidoDetails.getClienteNombre());
        pedido.setTipoArreglo(pedidoDetails.getTipoArreglo());
        pedido.setFechaEntrega(pedidoDetails.getFechaEntrega());
        pedido.setEstado(pedidoDetails.getEstado());
        return pedidoRepository.save(pedido);
    }
    
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
    
}

