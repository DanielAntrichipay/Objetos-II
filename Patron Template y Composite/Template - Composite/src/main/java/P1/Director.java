package P1;

import java.util.List;

public class Director extends Empleado {
    public Director(String nombre, Double sueldo) {
        super(nombre, sueldo);
    }

    public void asingnarGerente (Gerente gerente){
        this.empleadosACargo.add(gerente);
    }
}
