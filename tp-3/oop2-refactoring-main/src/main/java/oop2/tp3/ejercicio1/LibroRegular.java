package oop2.tp3.ejercicio1;

public class LibroRegular extends Libro{
    public LibroRegular(String nombre, int priceCode) {
        super(nombre, priceCode);
        this.monto = 2;
    }

    @Override
    public boolean PoseePuntosExtrasDeAlquiler() {
        return false;
    }

    @Override
    public Double clacularMonto(int diasAlquilados) {
        if (diasAlquilados > 2)
            this.monto += (diasAlquilados - 2) * 1.5;
        return this.monto;
    }
}
