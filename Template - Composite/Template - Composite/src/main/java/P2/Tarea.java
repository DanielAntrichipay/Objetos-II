package P2;

public class Tarea implements ItemDeProyecto{
    private int horas;
    private String Descripcion;

    public Tarea(String descripcion, int horas) {
        Descripcion = descripcion;
        this.horas = horas;
    }

    @Override
    public int calcularTiempoNecesario() {
        return 0;
    }
}
