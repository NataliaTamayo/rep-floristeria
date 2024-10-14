package com.example.Floristeriaspringboot.Repository;

import com.example.Floristeriaspringboot.Entities.EntregaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<EntregaEntity, Long> {
    // Métodos personalizados, si es necesario
}