package com.arreglos.busquedaOrdenamiento.persistence.dao;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;

import java.util.List;
import java.util.Optional;

public interface ViajeroDAO {

    List<Viajero> encontrarTodosViajeros();
    Optional<Viajero> EncontrarPorId(Long id);
    Optional<Viajero> crearViajero(Viajero viajero);
    void borrarViajero(Long id);

}
