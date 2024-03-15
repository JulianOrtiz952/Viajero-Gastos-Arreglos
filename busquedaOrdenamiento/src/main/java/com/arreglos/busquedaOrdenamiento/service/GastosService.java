package com.arreglos.busquedaOrdenamiento.service;

import com.arreglos.busquedaOrdenamiento.controller.dto.GastosDTO;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Gastos;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;
import com.arreglos.busquedaOrdenamiento.persistence.repository.GastosRepository;
import com.arreglos.busquedaOrdenamiento.persistence.repository.ViajeroRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GastosService {

    @Autowired
    private GastosRepository gastosRepository;

    @Autowired
    private ViajeroRepository viajeroRepository;

    public Gastos createGastos(GastosDTO gastosDTO){
        if(gastosDTO.getName().isBlank()) throw new RuntimeException("gasto is blank");
        gastosDTO.setName(gastosDTO.getName().toLowerCase());
        String name = gastosDTO.getName();
        if(!name.equals("comida")&&!name.equals("hospedaje")&&!name.equals("transporte")&&!name.equals("ropa")) throw new RuntimeException("las opciones son hospedaje, comida, ropa y transporte");
        return gastosRepository.save(Gastos.builder().id(gastosDTO.getId()).name(gastosDTO.getName()).costo(gastosDTO.getCosto()).viajero(gastosDTO.getViajero()).build());
    }

}
