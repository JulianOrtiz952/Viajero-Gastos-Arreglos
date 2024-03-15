package com.arreglos.busquedaOrdenamiento.persistence.dao.impl;

import com.arreglos.busquedaOrdenamiento.persistence.dao.ViajeroDAO;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Viajero;
import com.arreglos.busquedaOrdenamiento.persistence.repository.ViajeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ViajeroDAOImpl implements ViajeroDAO {

    @Autowired
    private ViajeroRepository viajeroRepository;


    @Override
    public List<Viajero> encontrarTodosViajeros() {
        return (List<Viajero>) viajeroRepository.findAll();
    }

    @Override
    public Optional<Viajero> EncontrarPorId(Long id) {
        return viajeroRepository.findById(id);
    }

    @Override
    public Optional<Viajero> crearViajero(Viajero viajero) {
        return Optional.of(viajeroRepository.save(viajero));
    }

    @Override
    public void borrarViajero(Long id) {
        viajeroRepository.deleteById(id);

    }
}
