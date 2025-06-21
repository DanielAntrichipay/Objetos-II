package P1;

import java.util.List;

public class EmpleadoRegular extends Empleado{

    public EmpleadoRegular(String nombre, Double sueldo) {
        super(nombre, sueldo);
    }

    @Override
    public Double calcularMontoTotalSalarial() {
        return this.sueldo;
    }
}
