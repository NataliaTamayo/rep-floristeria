package com.example.Floristeriaspringboot.Service;

import com.example.Floristeriaspringboot.Entities.FlorEntity;
import com.example.Floristeriaspringboot.Repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlorService {

    private final FlorRepository florRepository;

    @Autowired
    public FlorService(FlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    // Obtener todas las flores
    public List<FlorEntity> findAll() {
        return florRepository.findAll();
    }

    // Obtener una flor por ID
    public Optional<FlorEntity> getFlorById(Long id) {
        return florRepository.findById(id);
    }

    // Añadir una nueva flor
    public FlorEntity addFlor(FlorEntity flor) {
        return florRepository.save(flor);
    }

    // Actualizar una flor existente
    public Optional<FlorEntity> updateFlor(Long id, FlorEntity florDetails) {
        return florRepository.findById(id).map(flor -> {
            flor.setNombre(florDetails.getNombre()); 
            flor.setTipo(florDetails.getTipo());
            flor.setColor(florDetails.getColor());
            flor.setPrecio(florDetails.getPrecio());
            flor.setPrecioCompra(florDetails.getPrecioCompra());
            flor.setPrecioVenta(florDetails.getPrecioVenta());
            flor.setStock(florDetails.getStock());
            return Optional.of(florRepository.save(flor));
        }).orElse(Optional.empty());
    }

    // Eliminar una flor por ID
    public boolean deleteFlor(Long id) {
        try {
            if (florRepository.existsById(id)) {
                florRepository.deleteById(id);
                return true;
            }
        } catch (DataAccessException e) {
            // Manejo de excepciones al interactuar con la base de datos
            e.printStackTrace();
        }
        return false;
    }
}
