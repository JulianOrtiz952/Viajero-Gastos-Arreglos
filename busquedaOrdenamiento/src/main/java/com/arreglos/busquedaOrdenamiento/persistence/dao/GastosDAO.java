package com.arreglos.busquedaOrdenamiento.persistence.dao;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Gastos;

import java.util.List;
import java.util.Optional;

public interface GastosDAO {

    List<Gastos> encontrarTodosLosGastos();
    Optional<Gastos> encontrarGastoPorId(Long id);
    Optional<Gastos> crearGasto(Gastos gastos);
    void borrarGasto(Long id);

}
