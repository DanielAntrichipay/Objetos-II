package P5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrecioVentaDeRemeras {
    @Test
    public void testPrecioDeVentaDeRemeraNacional(){
        var remera = new RemeraNacional(30);
        var precioDeVentaEsperado = 40.95;
        assertEquals (precioDeVentaEsperado, remera.calcularPrecioDeVenta());
    }


    @Test
    public void testPrecioDeVentaDeRemeraInternacional(){
        var remera = new RemeraInternacional (30);
        var precioDeVentaEsperado = 39.9;
        assertEquals (precioDeVentaEsperado, remera.calcularPrecioDeVenta());
    }
}
