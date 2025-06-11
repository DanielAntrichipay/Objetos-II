package P4;

public abstract class Combo implements Pedido{
    private double precio;
    private String descripcion;

    @Override
    public double calcularCosto(){
        return precio;
    }
    public Combo(String descripcion, double precio){
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
