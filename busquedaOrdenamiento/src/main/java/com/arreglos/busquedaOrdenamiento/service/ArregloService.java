package com.arreglos.busquedaOrdenamiento.service;

import com.arreglos.busquedaOrdenamiento.persistence.entity.Arreglo;
import com.arreglos.busquedaOrdenamiento.persistence.repository.ArregloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ArregloService {
    @Autowired
    private ArregloRepository arregloRepository;

    public Arreglo createArreglo(Arreglo arreglo){
        if(arreglo==null) throw new RuntimeException("arreglo vacio");
        return arregloRepository.save(arreglo);
    }
    public Arreglo getArreglo(Long id){
        Optional<Arreglo> arregloOptional = arregloRepository.findById(id);
        if(arregloOptional.isEmpty()) throw  new RuntimeException("arreglo no encontrado");
        return arregloOptional.get();
    }

    public boolean deleteArreglo(Long id){
        Arreglo arreglo = getArreglo(id);
        arregloRepository.delete(arreglo);
        return true;
    }

    public int getNumero(Long id){
        Arreglo arreglo = getArreglo(id);
        int[]numeros= arrayOrdenado(arreglo.getNumeros());
        int i=0, numeroInicial=numeros[i];
        if(numeros[i]==numeros[i+1]-2) return numeros[i]+1;
        while(i<numeros.length-1){
            i++;
            if(numeros[i]==numeroInicial+1) {
                numeroInicial++;
            }
            else return numeroInicial+1;
        }
        return numeros[numeros.length-1]+1;
    }

    public String getRepetido(Long id){
        Arreglo arreglo = getArreglo(id);
        int[]numeros= arrayOrdenado(arreglo.getNumeros());
        for(int i=0; i<numeros.length-1; i++){
            if(numeros[i]==numeros[i++]) return "el nuemero repetido es: " + numeros[i];
        }
        return "no hay numeros repetidos";
    }

    public String getMenorYMayor(Long id){
        Arreglo arreglo = getArreglo(id);
        int[]numeros= arrayOrdenado(arreglo.getNumeros());
        return "el numero menor es: " + numeros[0] + " y el numero mayor es: " + numeros[numeros.length-1];
    }

    public int[] arrayOrdenado(int[]numeros){
        Arrays.sort(numeros);
        return numeros;
    }

    public String arregloPromedios(Long id){
        Arreglo arreglo = getArreglo(id);
        int[]numeros= arrayOrdenado(arreglo.getNumeros());
        int promedio = promedio(numeros);
        List<Integer> numerosSuperiores = new ArrayList<>(10);
        for(int i=0; i<numeros.length; i++){
            if(numeros[i]>promedio) numerosSuperiores.add(numeros[i]);
        }
        return "el promedio es: "+ promedio+ " y sus numeros superiores son: " +numerosSuperiores;
    }

    public int promedio(int[]numeros){
        int promedio=0;
        for(int i=0; i<numeros.length; i++){
            promedio+=numeros[i];
        }
        return promedio/numeros.length;
    }

    public String sumaDeNumerosParesEImpares(Long id){
        Arreglo arreglo = getArreglo(id);
        int[]numeros= arreglo.getNumeros();
        int numerosPares=0, numerosImpares=0;
        for(int i=0; i<numeros.length; i++){
            if(numeros[i]%2==0) numerosPares+=numeros[i];
            else numerosImpares+= numeros[i];
        }
        return "suma de numeros pares: " + numerosPares + " suma de numeros impares:" + numerosImpares;
    }

}
