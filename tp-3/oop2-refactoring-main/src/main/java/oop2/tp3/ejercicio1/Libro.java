package oop2.tp3.ejercicio1;

public abstract class Libro {
    private String nombre;
    private int codigoPrecio;
    double monto = 0;

    public Libro(String nombre, int priceCode) {
        this.monto = 0;
        this.nombre = nombre;
        this.codigoPrecio = priceCode;
    }

    public int codigoPrecio() {
        return codigoPrecio;
    }

    public String nombre() {
        return nombre;
    }
    public abstract boolean PoseePuntosExtrasDeAlquiler();
    public abstract Double clacularMonto(int diasAlquilados);
}