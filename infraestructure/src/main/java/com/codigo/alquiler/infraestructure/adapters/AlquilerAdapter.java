package com.codigo.alquiler.infraestructure.adapters;

import com.codigo.alquiler.domain.aggregates.contants.Constants;
import com.codigo.alquiler.domain.aggregates.dto.AlquilerDTO;
import com.codigo.alquiler.domain.ports.out.AlquilerServiceOut;
import com.codigo.alquiler.infraestructure.entity.AlquilerEntity;
import com.codigo.alquiler.infraestructure.mapper.AlquilerMapper;
import com.codigo.alquiler.infraestructure.repository.AlquilerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlquilerAdapter implements AlquilerServiceOut {

    private final AlquilerRepository alquilerRepository;
    private final AlquilerMapper alquilerMapper;
    @Override
    public AlquilerDTO crearAlquilerOut(AlquilerDTO alquilerDTO) {
        AlquilerEntity alquilerEntity = alquilerMapper.mapToEntity(alquilerDTO);
        alquilerEntity.setDateCreate(getTimestamp());
        alquilerRepository.save(alquilerEntity);
        return alquilerMapper.mapToDto(alquilerEntity);
    }

    @Override
    public Optional<AlquilerDTO> obtenerAlquilerOut(Long id) {
        return alquilerRepository.findById(id).map(alquilerMapper::mapToDto);
    }

    @Override
    public List<AlquilerDTO> obtenertodosOut() {
        return alquilerRepository.findAll().stream().map(alquilerMapper::mapToDto).toList();
    }

    @Override
    public AlquilerDTO actualizarOut(Long id, AlquilerDTO alquilerDTO) {
        if (alquilerRepository.existsById(id)){
            AlquilerEntity alquilerEntity = alquilerMapper.mapToEntity(alquilerDTO);
            alquilerEntity.setIdAlquiler(id);
            alquilerEntity.setDateUpdate(getTimestamp());
            alquilerEntity.setUsuarioUpdate(alquilerDTO.getUsuarioUpdate());
            alquilerRepository.save(alquilerEntity);
            return alquilerMapper.mapToDto(alquilerEntity);
        }
        return null;
    }

    @Override
    public AlquilerDTO deleteOut(Long id, String usuario) {
        if (alquilerRepository.existsById(id)){
           Optional<AlquilerEntity> entity=alquilerRepository.findById(id);
           entity.get().setEstado(Constants.STATUS_INACTIVE);
           entity.get().setDateDelete(getTimestamp());
           entity.get().setUsuarioDelete(usuario);
           alquilerRepository.save(entity.get());
           return alquilerMapper.mapToDto(entity.get());
        }
        return null;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp= new Timestamp(currentTime);
        return timestamp;
    }
}
