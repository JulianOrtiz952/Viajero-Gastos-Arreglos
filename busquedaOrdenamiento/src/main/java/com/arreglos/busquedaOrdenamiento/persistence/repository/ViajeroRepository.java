package com.arreglos.busquedaOrdenamiento.persistence.repository;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajeroRepository extends CrudRepository<Viajero, Long> {
}
