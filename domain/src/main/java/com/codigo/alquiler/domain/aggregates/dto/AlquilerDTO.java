package com.codigo.alquiler.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlquilerDTO {
    private Long idAlquiler;
    private String nroAlquiler;
    private Long idUsuario;
    private Long idVehiculo;
    private Timestamp fraInicio;
    private Timestamp fraFin;
    private String lugarRecojo;
    private String latitudRecojo;
    private String longitudRecojo;
    private Integer estado;
    private String usuarioCreate;
    private Timestamp dateCreate;
    private String usuarioUpdate;
    private Timestamp dateUpdate;
    private String usuarioDelete;
    private Timestamp dateDelete;
}
