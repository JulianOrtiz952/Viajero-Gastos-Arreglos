package com.arreglos.busquedaOrdenamiento.persistence.dao.impl;

import com.arreglos.busquedaOrdenamiento.persistence.dao.GastosDAO;
import com.arreglos.busquedaOrdenamiento.persistence.entity.Gastos;
import com.arreglos.busquedaOrdenamiento.persistence.repository.GastosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GastosDAOImpl implements GastosDAO {

    private GastosRepository gastosRepository;

    @Override
    public List<Gastos> encontrarTodosLosGastos() {
        return (List<Gastos>) gastosRepository.findAll();
    }

    @Override
    public Optional<Gastos> encontrarGastoPorId(Long id) {
        return gastosRepository.findById(id);
    }

    @Override
    public Optional<Gastos> crearGasto(Gastos gastos) {
        return Optional.of(gastosRepository.save(gastos));
    }

    @Override
    public void borrarGasto(Long id) {
        gastosRepository.deleteById(id);
    }
}
