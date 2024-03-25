package com.codigo.alquiler.application.controller;

import com.codigo.alquiler.domain.aggregates.dto.AlquilerDTO;
import com.codigo.alquiler.domain.ports.in.AlquilerServiceIn;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alquiler")
@RequiredArgsConstructor
public class AlquilerController {

    private AlquilerServiceIn alquilerServiceIn;

    @PostMapping
    public ResponseEntity<AlquilerDTO> registrar(@RequestBody AlquilerDTO alquilerDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alquilerServiceIn.crearAlquilerIn(alquilerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlquilerDTO> obtenerAlquiler(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alquilerServiceIn.obtenerAlquilerIn(id));
    }

    @GetMapping()
    public ResponseEntity<List<AlquilerDTO>> obtenerTodos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alquilerServiceIn.obtenertodosIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlquilerDTO> actualizar(@PathVariable Long id, @RequestBody AlquilerDTO alquilerDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alquilerServiceIn.actualizarIn(id, alquilerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlquilerDTO> eliminar(@PathVariable Long id, @RequestHeader String usuario){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alquilerServiceIn.deleteIn(id, usuario));
    }
}
