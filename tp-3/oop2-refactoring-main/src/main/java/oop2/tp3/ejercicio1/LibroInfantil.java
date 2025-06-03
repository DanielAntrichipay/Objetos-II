package oop2.tp3.ejercicio1;

public class LibroInfantil extends Libro {
    public LibroInfantil(String nombre, int priceCode) {
        super(nombre, priceCode);
        this.monto = 1.5;
    }

    @Override
    public boolean PoseePuntosExtrasDeAlquiler() {
        return false;
    }

    @Override
    public Double clacularMonto(int diasAlquilados) {
        if (diasAlquilados > 3)
            this.monto += (diasAlquilados - 3) * 1.5;
        return this.monto;
    }
}
