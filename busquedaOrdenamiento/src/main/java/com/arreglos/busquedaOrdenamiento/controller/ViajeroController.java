package com.arreglos.busquedaOrdenamiento.controller;

import com.arreglos.busquedaOrdenamiento.controller.dto.ViajeroDTO;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;
import com.arreglos.busquedaOrdenamiento.service.ViajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viajero")
public class ViajeroController {

    @Autowired
    private ViajeroService viajeroService;

    @PostMapping
    public ResponseEntity<?> createViajero(@RequestBody ViajeroDTO viajeroDTO){
        return ResponseEntity.ok(viajeroService.createViajero(viajeroDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGastosPorViajero(@PathVariable Long id, @RequestBody String name){
        return ResponseEntity.ok(viajeroService.obtenerGastosPorViajero(id, name));
    }

    @GetMapping("/getmayorgasto/{id}")
    public ResponseEntity<?> getMayotGasto(@PathVariable Long id){
        return ResponseEntity.ok(viajeroService.obtenerGastoMayor(id));
    }



}
