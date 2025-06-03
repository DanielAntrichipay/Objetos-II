package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;
    private int puntosAlquilerFrecuente = 0;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public double calcularDeuda (){
        //Esta parte de recorrer la podria sacar en un lambda
        double deudaTotal = 0;
        for (Alquiler alquiler : alquileres) {
            deudaTotal += alquiler.calcularMonto();
        }
        return deudaTotal;
    }

    public int calcularPuntosFrecuentes (){
        //Esta parte de recorrer la podria sacar en un lambda
        for (Alquiler alquiler : alquileres) {
            puntosAlquilerFrecuente += alquiler.calcularPuntosDeAlquiler();
        }
        return puntosAlquilerFrecuente;
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
}