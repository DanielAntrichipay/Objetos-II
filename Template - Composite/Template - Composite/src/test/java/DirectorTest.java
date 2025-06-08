import P1.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectorTest {

    @Test
    public void testCalcularMontoTotalSalarialConArbolCompleto (){
        var director = new Director("Jose", 100000.0);
        var gerente1 = new Gerente("g1", 10000.0);
        var mandoMedio1 = new MandoMedio("m1", 1000.0);
        var liderDeProyecto1 = new LiderDeProyecto("l1", 100.0);
        var empleadoRegular1 = new EmpleadoRegular("n1", 10.0);
        var empleadoRegular2 = new EmpleadoRegular("n2", 10.0);

        director.asingnarGerente(gerente1);
        gerente1.asingnarMandoMedio(mandoMedio1);
        mandoMedio1.asingnarLiderDeProyecto(liderDeProyecto1);
        liderDeProyecto1.asingnarEmpleadoRegular(empleadoRegular1);
        liderDeProyecto1.asingnarEmpleadoRegular(empleadoRegular2);

        double montoTotalSalarialEsperado = 111120.0;
        assertEquals (montoTotalSalarialEsperado, director.calcularMontoTotalSalarial());
    }

    @Test
    public void testCalcularMontoTotalSalarialConArbolIncompleto (){
        var director = new Director("Jose", 100000.0);
        var gerente1 = new Gerente("g1", 10000.0);
        var mandoMedio1 = new MandoMedio("m1", 1000.0);
        var liderDeProyecto1 = new LiderDeProyecto("l1", 100.0);


        director.asingnarGerente(gerente1);
        gerente1.asingnarMandoMedio(mandoMedio1);
        mandoMedio1.asingnarLiderDeProyecto(liderDeProyecto1);

        double montoTotalSalarialEsperado = 111100.0;
        assertEquals (montoTotalSalarialEsperado, director.calcularMontoTotalSalarial());
    }
}
