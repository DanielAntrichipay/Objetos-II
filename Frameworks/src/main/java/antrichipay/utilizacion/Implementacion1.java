package antrichipay.utilizacion;

import antrichipay.framework.Accion;

public class ImprimirAcciones1 implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando Implementacion uno.");
    }

    @Override
    public String nombreItemMenu() {
        return "Implementacion uno";
    }

    @Override
    public String descripcionItemMenu() {
        return "Una implementacion";
    }
}
