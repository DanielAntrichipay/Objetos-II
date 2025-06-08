package P1;

import java.util.List;

public class MandoMedio extends Empleado {

    public MandoMedio(String nombre, Double sueldo) {
        super(nombre, sueldo);
    }

    public void asingnarLiderDeProyecto (LiderDeProyecto liderDeProyecto){
        this.empleadosACargo.add(liderDeProyecto);
    }
}
