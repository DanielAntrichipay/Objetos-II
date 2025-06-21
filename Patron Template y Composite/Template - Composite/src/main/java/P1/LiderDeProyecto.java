package P1;

import java.util.List;

public class LiderDeProyecto extends Empleado {

    public LiderDeProyecto(String nombre, Double sueldo) {
        super(nombre, sueldo);
    }

    public void asingnarEmpleadoRegular (EmpleadoRegular empleadoRegular){
        this.empleadosACargo.add(empleadoRegular);
    }
}
