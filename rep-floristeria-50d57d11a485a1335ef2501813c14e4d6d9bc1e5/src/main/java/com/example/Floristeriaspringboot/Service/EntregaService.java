package com.example.Floristeriaspringboot.Service;

import com.example.Floristeriaspringboot.Entities.EntregaEntity;
import com.example.Floristeriaspringboot.Repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    public List<EntregaEntity> findAll() {
        return entregaRepository.findAll();
    }

    public void addEntrega(EntregaEntity entrega) {
        entregaRepository.save(entrega);
    }

    // Otros métodos según sea necesario
}