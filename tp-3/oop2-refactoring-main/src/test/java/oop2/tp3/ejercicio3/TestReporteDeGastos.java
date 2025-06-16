package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReporteDeGastos {
    @Test
    public void reporteTest (){
        var gasto1 = new GastoDesayuno(1000);
        var gasto2 = new GastoDeCena(3000);
        var gasto3 = new GastoDeAlquilerDeAuto(10000);
        var reporte = new ReporteDeGastos();
        var salidaEsperada = "Expenses 2025-06-16" + System.lineSeparator() +
                "Desayuno: 1000 [X]" + System.lineSeparator() +
                "Cena: 3000" + System.lineSeparator() +
                "Alquiler de auto: 10000" + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                "Gastos de comida: 4000" + System.lineSeparator() +
                "Total de gastos: 14000";

        reporte.agregarGastoComun(gasto3);
        reporte.agregarGatoDeComida(gasto1);
        reporte.agregarGatoDeComida(gasto2);

        assertEquals (salidaEsperada, reporte.obtenerReporte());
    }
}
