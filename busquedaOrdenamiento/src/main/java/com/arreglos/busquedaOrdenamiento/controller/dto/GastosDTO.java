package com.arreglos.busquedaOrdenamiento.controller.dto;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;
import lombok.*;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GastosDTO {

    private Long id;
    private String name;
    private double costo;
    private Viajero viajero;

}
