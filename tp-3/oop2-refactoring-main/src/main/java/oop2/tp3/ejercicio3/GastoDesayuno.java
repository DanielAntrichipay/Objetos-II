package oop2.tp3.ejercicio3;

public class GastoDesayuno extends Gasto{
    public GastoDesayuno(int monto) {
        super(monto, "Desayuno");
        this.montoLimiteAntesDelExceso = 1000;
    }
}
