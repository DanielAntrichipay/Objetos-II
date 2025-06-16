package oop2.tp3.ejercicio3;

public class GastoDeAlquilerDeAuto extends Gasto{
    public GastoDeAlquilerDeAuto(int monto) {
        super(monto, "Alquiler de auto");
        this.montoLimiteAntesDelExceso = -1;
    }
    @Override
    public  boolean tuvoExceso(){
        return false;
    }
}
