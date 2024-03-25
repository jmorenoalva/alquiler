package com.codigo.alquiler.infraestructure.repository;

import com.codigo.alquiler.infraestructure.entity.AlquilerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlquilerRepository extends JpaRepository<AlquilerEntity, Long> {

    AlquilerEntity findByNroAlquiler(String nroAlquiler);
    List<AlquilerEntity> findByEstado(@Param("estado") Integer estado);
}
