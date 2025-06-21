package P4;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPromocionDelVA {
    @Test
    public void testCalculadorJubilado (){
        var log = new LogTransaction();
        var calculadorJubilado = new CalculadorJubilado(log, LocalDate.now().getMonth().getValue());
        var totalEsperado = 30;

        assertEquals (totalEsperado, calculadorJubilado.calcularPrecio(30));
    }

    @Test
    public void testCalculadorNoJubilado (){
        var log = new LogTransaction();
        var calculadorNoJubilado = new CalculadorNoJubilado(log, LocalDate.now().getMonth().getValue());
        var totalEsperado = 34.5;

        assertEquals (totalEsperado, calculadorNoJubilado.calcularPrecio(30));
    }
}
