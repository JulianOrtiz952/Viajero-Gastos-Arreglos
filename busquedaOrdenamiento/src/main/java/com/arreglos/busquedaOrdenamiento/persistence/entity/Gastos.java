package com.arreglos.busquedaOrdenamiento.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double costo;
    @ManyToOne
    @JoinColumn(name = "id_viajero", nullable = false)
    @JsonIgnore
    private Viajero viajero;
}
