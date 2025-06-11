package P4;

public abstract class PorcionAdicional implements Pedido{
    private double costo;
    private Pedido pedido;
    @Override
    public double calcularCosto(){
        return costo;
    }
    public PorcionAdicional(double costo, Pedido pedido){
        this.pedido = pedido;
        this.costo = costo;
    }
}
