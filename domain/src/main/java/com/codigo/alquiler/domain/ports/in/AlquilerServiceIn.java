package com.codigo.alquiler.domain.ports.in;

import com.codigo.alquiler.domain.aggregates.dto.AlquilerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AlquilerServiceIn {
    AlquilerDTO crearAlquilerIn(AlquilerDTO alquilerDTO);
    AlquilerDTO obtenerAlquilerIn(Long id);
    List<AlquilerDTO> obtenertodosIn();
    AlquilerDTO actualizarIn(Long id, AlquilerDTO alquilerDTO);
    AlquilerDTO deleteIn(Long id, String usuario);
}
