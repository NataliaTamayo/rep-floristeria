package com.example.Floristeriaspringboot.Repository;

import com.example.Floristeriaspringboot.Entities.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {
    // Puedes agregar métodos personalizados si es necesario
}