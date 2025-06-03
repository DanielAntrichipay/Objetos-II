package oop2.tp3.ejercicio1;

public class LibroRecienLanzado extends Libro{
    public LibroRecienLanzado(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public boolean PoseePuntosExtrasDeAlquiler() {
        return true;
    }

    @Override
    public Double clacularMonto(int diasAlquilados) {
        this.monto += diasAlquilados * 3;
        return this.monto;
    }
}
