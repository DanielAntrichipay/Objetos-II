package P1;

import java.util.List;

public class Gerente extends Empleado {

    public Gerente(String nombre, Double sueldo) {
        super(nombre, sueldo);
    }

    public void asingnarMandoMedio (MandoMedio mandoMedio){
        this.empleadosACargo.add(mandoMedio);
    }

}
