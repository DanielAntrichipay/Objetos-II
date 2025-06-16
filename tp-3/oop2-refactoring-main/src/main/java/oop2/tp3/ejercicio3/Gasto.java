package oop2.tp3.ejercicio3;

public abstract class Gasto {
    public static final String EL_MONTO_ES_INVALIDO = "El monto no puede ser menor o igual a 0";
    protected String nombre;
    protected int monto;
    protected int montoLimiteAntesDelExceso;

    public Gasto(int monto, String nombre) {
        this.checkMonto(monto);
        this.monto = monto;
        this.nombre = nombre;
    }

    public int consultarMonto (){
        return monto;
    }

    public String obtenerGastoFormateado() {
        String marcaDeExeso = "";
        if (this.tuvoExceso()){
            marcaDeExeso = " [X]";
        }
        return this.nombre + ": " + this. monto + marcaDeExeso + System.lineSeparator();
    }

    public  boolean tuvoExceso(){
        if (this.monto >= this.montoLimiteAntesDelExceso){
            return true;
        }
        return false;
    }

    private void checkMonto(int monto) {
        if (monto <= 0){
            throw new RuntimeException(EL_MONTO_ES_INVALIDO);
        }
    }

}
