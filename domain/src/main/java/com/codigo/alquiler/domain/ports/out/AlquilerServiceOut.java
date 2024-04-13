package com.codigo.alquiler.domain.ports.out;

import com.codigo.alquiler.domain.aggregates.dto.AlquilerDTO;

import java.util.List;
import java.util.Optional;

public interface AlquilerServiceOut {
    AlquilerDTO crearAlquilerOut(AlquilerDTO alquilerDTO);

    Optional<AlquilerDTO> obtenerAlquilerOut(Long id);
    List<AlquilerDTO> obtenertodosOut();
    AlquilerDTO actualizarOut(Long id, AlquilerDTO alquilerDTO);
    AlquilerDTO deleteOut(Long id, String usuario);
}
