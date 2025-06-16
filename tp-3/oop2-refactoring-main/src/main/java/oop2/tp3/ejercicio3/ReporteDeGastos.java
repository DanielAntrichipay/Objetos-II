package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReporteDeGastos {
    private List<Gasto> listaDeGastosAlimentarios = new ArrayList<>();
    private List<Gasto> listaDeGasrosComunes = new ArrayList<>();
    private int total;
    private int gastosDeComida = 0;

    public void agregarGatoDeComida (Gasto gastoDeComida){
        this.listaDeGastosAlimentarios.add(gastoDeComida);
    }

    public void agregarGastoComun (Gasto gastoComun){
        this.listaDeGasrosComunes.add(gastoComun);
    }

    public String obtenerReporte() {
        String reporte = "Expenses " + LocalDate.now() + System.lineSeparator();

        for (Gasto gasto : listaDeGastosAlimentarios) {
            reporte = reporte + "" + gasto.obtenerGastoFormateado();
            gastosDeComida += gasto.consultarMonto();
        }
        for (Gasto gasto : listaDeGasrosComunes){
            reporte = reporte + "" + gasto.obtenerGastoFormateado();
            total += gasto.consultarMonto();
        }

        total += gastosDeComida;
        return reporte + System.lineSeparator() + System.lineSeparator() + "Gastos de comida: " + gastosDeComida + System.lineSeparator() + "Total de gastos: " + total;
    }
}
