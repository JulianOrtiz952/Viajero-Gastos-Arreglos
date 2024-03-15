package com.arreglos.busquedaOrdenamiento.controller;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Arreglo;
import com.arreglos.busquedaOrdenamiento.service.ArregloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arreglo")
public class ArregloController {

    @Autowired
    private ArregloService arregloService;

    @PostMapping
    public ResponseEntity<Arreglo> createArreglo(@RequestBody Arreglo arreglo){
        return ResponseEntity.ok(arregloService.createArreglo(arreglo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arreglo> getArreglo(@PathVariable Long id){
        return ResponseEntity.ok(arregloService.getArreglo(id));
    }

    @GetMapping("/numero/{id}")
    public ResponseEntity<Integer> getNumeroArreglo(@PathVariable Long id){
        return ResponseEntity.ok(arregloService.getNumero(id));
    }

    @GetMapping("/numerorepetido/{id}")
    public ResponseEntity<String> getNumeroRepetido(@PathVariable Long id){
        return ResponseEntity.ok(arregloService.getRepetido(id));
    }

    @GetMapping("/numeromenorymayor/{id}")
    public ResponseEntity<String> getMenorYMayor(@PathVariable Long id){
        return ResponseEntity.ok(arregloService.getMenorYMayor(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteArreglo(@PathVariable Long id){
        return ResponseEntity.ok(arregloService.deleteArreglo(id));
    }

    @GetMapping("/promedio/{id}")
    public ResponseEntity<String> getPromedio(@PathVariable Long id){
        return ResponseEntity.ok(arregloService.arregloPromedios(id));
    }

    @GetMapping("/sumadenumerospareseimpares/{id}")
    public ResponseEntity<String> getSuma(@PathVariable Long id){
        return ResponseEntity.ok(arregloService.sumaDeNumerosParesEImpares(id));
    }

}
