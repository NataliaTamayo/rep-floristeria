package com.example.Floristeriaspringboot.Service;




import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Floristeriaspringboot.Entities.FlorEntity;
import com.example.Floristeriaspringboot.Repository.FlorRepository;

@Service
public class FlorService<Flor> {

    private final FlorRepository florRepository;

    public FlorService(FlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    public List<FlorEntity>findAll() {
        return florRepository.findAll();
    }

    public FlorEntity save(FlorEntity flor) { // Cambiado Flor a FlorEntity
        return florRepository.save(flor); // Retorna la flor guardada
    }

    
}
