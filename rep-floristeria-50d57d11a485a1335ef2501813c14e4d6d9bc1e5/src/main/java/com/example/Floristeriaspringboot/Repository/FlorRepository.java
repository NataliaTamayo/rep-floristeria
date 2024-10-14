package com.example.Floristeriaspringboot.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Floristeriaspringboot.Entities.FlorEntity;

@Repository

public interface FlorRepository extends JpaRepository<FlorEntity, Long> {
}
