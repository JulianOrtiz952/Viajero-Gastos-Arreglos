package com.arreglos.busquedaOrdenamiento.service;


import com.arreglos.busquedaOrdenamiento.controller.dto.ViajeroDTO;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Gastos;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;
import com.arreglos.busquedaOrdenamiento.persistence.repository.ViajeroRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class ViajeroService {
    @Autowired
    private ViajeroRepository viajeroRepository;

    public Viajero createViajero(ViajeroDTO viajeroDTO){
        if(viajeroDTO.getName().isBlank()) throw new RuntimeException("name is blank");
        return viajeroRepository.save(Viajero.builder().name(viajeroDTO.getName()).build());
    }

    public double obtenerGastosPorViajero(Long id, String name){
        Viajero viajero = viajeroRepository.findById(id).orElseThrow();
        return viajero.getGastos().stream().filter(gastos -> gastos.getName().equals(name)).mapToDouble(Gastos::getCosto).sum();
    }

    public double obtenerGastoMayor(Long id){
        Viajero viajero = viajeroRepository.findById(id).orElseThrow();
        return viajero.getGastos().stream().mapToDouble(Gastos::getCosto).max().orElse(0.0);
    }

}
