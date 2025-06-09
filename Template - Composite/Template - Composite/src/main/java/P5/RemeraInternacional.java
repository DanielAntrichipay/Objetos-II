package P5;

public class RemeraInternacional extends Remera{

    public RemeraInternacional(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    public double aplicarRecargo() {
        double recargo = 0.03;
        return this.precioUnitario * recargo;
    }

    @Override
    public double aplicarImpuestoAduanuero() {
        double impuestoAduanero = 0.05;
        return this.precioUnitario * impuestoAduanero;
    }

    @Override
    public double aplicarBonificacion() {
        return 0;
    }

    @Override
    public double aplicarPorcentajeDeGanacia() {
        double porcentajeDeGanancia = 0.25;
        return this.precioUnitario * porcentajeDeGanancia;
    }
}
