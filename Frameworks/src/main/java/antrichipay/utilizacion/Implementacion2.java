package antrichipay.utilizacion;

import antrichipay.framework.Accion;

public class ImprimirAcciones2 implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando Implementacion dos.");
    }

    @Override
    public String nombreItemMenu() {
        return "Implementacion dos";
    }

    @Override
    public String descripcionItemMenu() {
        return "Una implementacion";
    }
}
