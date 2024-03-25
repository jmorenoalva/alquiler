package com.codigo.alquiler.infraestructure.mapper;

import com.codigo.alquiler.domain.aggregates.dto.AlquilerDTO;
import com.codigo.alquiler.infraestructure.entity.AlquilerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AlquilerMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public AlquilerDTO mapToDto(AlquilerEntity alquilerEntity){
        return modelMapper.map(alquilerEntity, AlquilerDTO.class);
    }

    public AlquilerEntity mapToEntity(AlquilerDTO alquilerDTO){
        return modelMapper.map(alquilerDTO, AlquilerEntity.class);
    }
}
