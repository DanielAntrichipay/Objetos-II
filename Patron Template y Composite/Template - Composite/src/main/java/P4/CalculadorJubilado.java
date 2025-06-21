package P4;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public class CalculadorJubilado extends Calculador {

    public CalculadorJubilado(LogTransaction log, int mesEnPromocion) {
        super(log, mesEnPromocion);
    }

    @Override
    public double calcularDescuento(double precioProducto) {
        if (!of(mesEnPromocion).equals(now().getMonth())) {
            return precioProducto * 0.1;
        }
        return 0.0;
    }
}