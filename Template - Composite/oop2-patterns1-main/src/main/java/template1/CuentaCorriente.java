package template1;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(float saldo) {
        super(saldo);
    }

    @Override
    protected boolean puedeRetirar(Float saldoARetirar) {
        return true;
    }

}
