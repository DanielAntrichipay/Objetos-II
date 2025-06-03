package oop2.tp3.Ejercicio1;

import oop2.tp3.ejercicio1.Cliente;
import oop2.tp3.ejercicio1.Alquiler;
import oop2.tp3.ejercicio1.CopiaLibro;
import oop2.tp3.ejercicio1.LibroRegular;
import oop2.tp3.ejercicio1.LibroRecienLanzado;
import oop2.tp3.ejercicio1.LibroInfantil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlquiler {

    @Test
    public void testCalcularDeuda (){
        double deudaEsperada = 13.0;
        var cliente = new Cliente("Ysabell");
        var libro1 = new LibroRegular("Mort - Terry Pratchett", 32);
        var libro2 = new LibroRegular("El Color de la Magia - Terry Pratchett", 23);
        var copia1 = new CopiaLibro(libro1);
        var copia2 = new CopiaLibro(libro2);
        var alquiler1 = new Alquiler(copia1, 5);
        var alquiler2 = new Alquiler(copia2, 5);

        cliente.alquilar(alquiler1);
        cliente.alquilar(alquiler2);

        assertEquals (deudaEsperada, cliente.calcularDeuda());
    }

    @Test
    public void testCalcularPuntosFrecuentes (){
        int puntosFrecuentesEsperados = 2;
        var cliente = new Cliente("Berta");
        var libro1 = new LibroInfantil("La Gallina Degollada - Horacio Quiroga", 32);
        var libro2 = new LibroInfantil("El Almohadón de Plumas - Horacio Quiroga", 23);
        var copia1 = new CopiaLibro(libro1);
        var copia2 = new CopiaLibro(libro2);
        var alquiler1 = new Alquiler(copia1, 5);
        var alquiler2 = new Alquiler(copia2, 5);

        cliente.alquilar(alquiler1);
        cliente.alquilar(alquiler2);

        assertEquals (puntosFrecuentesEsperados, cliente.calcularPuntosFrecuentes());
    }
    @Test
    public void testCalcularDeudaDeLibrosRecienLanzados (){
        double deudaEsperada = 30.0;
        var cliente = new Cliente("Death");
        var libro1 = new LibroRecienLanzado("Mort - Terry Pratchett", 32);
        var libro2 = new LibroRecienLanzado("El Color de la Magia - Terry Pratchett", 23);
        var copia1 = new CopiaLibro(libro1);
        var copia2 = new CopiaLibro(libro2);
        var alquiler1 = new Alquiler(copia1, 5);
        var alquiler2 = new Alquiler(copia2, 5);

        cliente.alquilar(alquiler1);
        cliente.alquilar(alquiler2);

        assertEquals (deudaEsperada, cliente.calcularDeuda());
    }
}
