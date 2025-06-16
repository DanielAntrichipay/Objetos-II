package oop2.tp3.ejercicio3;

public class GastoDeCena extends Gasto{

    public GastoDeCena(int monto) {
        super(monto, "Cena");
        this.montoLimiteAntesDelExceso = 5000;
    }

}
