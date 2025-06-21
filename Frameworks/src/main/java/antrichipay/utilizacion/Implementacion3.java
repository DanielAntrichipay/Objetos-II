package antrichipay.utilizacion;

import antrichipay.framework.Accion;

public class ImprimirAcciones3 implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando Implementacion tres.");
    }

    @Override
    public String nombreItemMenu() {
        return "Implementacion tres";
    }

    @Override
    public String descripcionItemMenu() {
        return "Una implementacion";
    }
}
