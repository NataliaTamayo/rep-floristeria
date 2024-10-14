package com.example.Floristeriaspringboot.Service;

import com.example.Floristeriaspringboot.Entities.FacturaEntity;
import com.example.Floristeriaspringboot.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public List<FacturaEntity> findAll() {
        return facturaRepository.findAll();
    }

    public void addFactura(FacturaEntity factura) {
        facturaRepository.save(factura);
    }

    // Otros métodos según las necesidades (por ejemplo, buscar por ID)
}