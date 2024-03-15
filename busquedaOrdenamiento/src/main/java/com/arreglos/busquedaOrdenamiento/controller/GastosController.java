package com.arreglos.busquedaOrdenamiento.controller;

import com.arreglos.busquedaOrdenamiento.controller.dto.GastosDTO;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Gastos;
import com.arreglos.busquedaOrdenamiento.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gastos")
public class GastosController {

    @Autowired
    private GastosService gastosService;

    @PostMapping
    public ResponseEntity<Gastos> createGastos(@RequestBody GastosDTO gastosDTO) {
        return ResponseEntity.ok(gastosService.createGastos(gastosDTO));
    }

}