package com.codigo.alquiler.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@NamedQuery(name="AlquilerEntity.findByEstado", query="SELECT a FROM AlquilerEntity a where a.estado=:estado")
@Entity
@Getter
@Setter
@Table(name = "alquiler")
public class AlquilerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Long idAlquiler;
    @Column(name = "nro_alquiler",nullable = false,length = 10)
    private String nroAlquiler;
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    @Column(name = "fra_inicio")
    private Timestamp fraInicio;
    @Column(name = "fra_fin")
    private Timestamp fraFin;
    @Column(name = "lugar_recojo", nullable = false, length = 250)
    private String lugarRecojo;
    @Column(name = "latitud_recojo", length = 20)
    private String latitudRecojo;
    @Column(name = "longitud_recojo", length = 20)
    private String longitudRecojo;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "usuario_create", nullable = false, length = 10)
    private String usuarioCreate;
    @Column(name = "date_create")
    private Timestamp dateCreate;
    @Column(name = "usuario_update", nullable = false, length = 10)
    private String usuarioUpdate;
    @Column(name = "date_update")
    private Timestamp dateUpdate;
    @Column(name = "usuario_delete", nullable = false, length = 10)
    private String usuarioDelete;
    @Column(name = "date_delete")
    private Timestamp dateDelete;
}
