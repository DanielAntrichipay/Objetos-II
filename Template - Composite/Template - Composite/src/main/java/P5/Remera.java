package P5;

public abstract class Remera {
    protected double precioUnitario;

    public Remera(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double calcularPrecioDeVenta(){
        return this.precioUnitario + this.aplicarRecargo() + this.aplicarImpuestoAduanuero() + aplicarBonificacion() + aplicarPorcentajeDeGanacia();
    }

    public abstract double aplicarRecargo ();

    public abstract double aplicarImpuestoAduanuero ();

    public abstract double aplicarBonificacion ();

    public abstract double aplicarPorcentajeDeGanacia();
}
