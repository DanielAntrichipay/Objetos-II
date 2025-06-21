package P5;

public class RemeraNacional extends Remera{

    public RemeraNacional(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    public double aplicarRecargo() {
        double Recargo = 0.015;
        return this.precioUnitario * Recargo;
    }

    @Override
    public double aplicarImpuestoAduanuero() {
        return 0;
    }

    @Override
    public double aplicarBonificacion() {
        double Bonificacion = 0.20;
        return this.precioUnitario * Bonificacion;
    }

    @Override
    public double aplicarPorcentajeDeGanacia() {
        double porcentajeDeGanacia = 0.15;
        return this.precioUnitario * porcentajeDeGanacia;
    }
}
