package com.codigo.alquiler.domain.impl;

import com.codigo.alquiler.domain.aggregates.dto.AlquilerDTO;
import com.codigo.alquiler.domain.ports.in.AlquilerServiceIn;
import com.codigo.alquiler.domain.ports.out.AlquilerServiceOut;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlquilerServiceImpl implements AlquilerServiceIn {

    private AlquilerServiceOut alquilerServiceOut;
    @Override
    public AlquilerDTO crearAlquilerIn(AlquilerDTO alquilerDTO) {
        return alquilerServiceOut.crearAlquilerOut(alquilerDTO);
    }

    @Override
    public AlquilerDTO obtenerAlquilerIn(Long id) {
        Optional<AlquilerDTO> alquilerDTO = alquilerServiceOut.obtenerAlquilerOut(id);
        if (alquilerDTO.isEmpty()) {
            throw new IllegalArgumentException("Id invalido");
        }
        return alquilerDTO.get();
    }

    @Override
    public List<AlquilerDTO> obtenertodosIn() {
        return alquilerServiceOut.obtenertodosOut();
    }

    @Override
    public AlquilerDTO actualizarIn(Long id, AlquilerDTO alquilerDTO) {
        return alquilerServiceOut.actualizarOut(id, alquilerDTO);
    }

    @Override
    public AlquilerDTO deleteIn(Long id, String usuario) {
        return alquilerServiceOut.deleteOut(id, usuario);
    }
}
