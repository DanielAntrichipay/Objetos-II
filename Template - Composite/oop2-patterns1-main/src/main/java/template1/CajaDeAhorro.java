package template1;

public class CajaDeAhorro extends CuentaBancaria {
    public CajaDeAhorro(float saldo) {
        super(saldo);
    }

    @Override
    protected boolean puedeRetirar(Float saldoARetirar) {
        return this.saldo >= saldoARetirar;
    }
}
