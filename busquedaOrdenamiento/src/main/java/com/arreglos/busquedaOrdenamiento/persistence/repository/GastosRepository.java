package com.arreglos.busquedaOrdenamiento.persistence.repository;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Gastos;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastosRepository extends CrudRepository<Gastos, Long> {

}
