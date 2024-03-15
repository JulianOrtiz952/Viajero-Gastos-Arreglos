package com.arreglos.busquedaOrdenamiento.controller.dto;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Gastos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViajeroDTO {

    private Long id;
    private String name;
    private List<Gastos> gastosList = new ArrayList<>();

}
