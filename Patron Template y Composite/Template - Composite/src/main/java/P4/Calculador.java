package P4;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class Calculador {
    protected LogTransaction log;
    protected int mesEnPromocion;

    public Calculador(LogTransaction log, int mesEnPromocion) {
        this.log = log;
        this.mesEnPromocion = mesEnPromocion;
    }

    public double calcularPrecio(double precioProducto) {
        double precioTotal = precioProducto + calcularDescuento(precioProducto);
        log.log(CalculadorNoJubilado.class.getName());
        return precioTotal;
    }
    public abstract double calcularDescuento (double precioProducto);
}