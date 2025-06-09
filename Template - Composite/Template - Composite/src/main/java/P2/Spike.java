package P2;

public class Spike implements ItemDeProyecto{
    private int horas;
    private String Descripcion;

    public Spike(String descripcion, int horas) {
        Descripcion = descripcion;
        this.horas = horas;
    }

    @Override
    public int calcularTiempoNecesario() {
        return horas;
    }
}
