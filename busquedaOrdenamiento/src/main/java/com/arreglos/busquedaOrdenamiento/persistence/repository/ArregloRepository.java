package com.arreglos.busquedaOrdenamiento.persistence.repository;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Arreglo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArregloRepository extends CrudRepository<Arreglo, Long> {
}
