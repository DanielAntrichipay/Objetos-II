package P1;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado implements Contrato{
    String nombre;
    Double sueldo;
    List<Empleado> empleadosACargo = new ArrayList<>();

    public Empleado(String nombre, Double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public Double calcularMontoTotalSalarial() {
        Double montoTotal = this.sueldo;
        for (Contrato empleado : this.empleadosACargo){
            montoTotal += empleado.calcularMontoTotalSalarial();
        }
        return montoTotal;
    }

}
