package P2;

import java.util.ArrayList;
import java.util.List;

public class HistoriaDeUsuario implements ItemDeProyecto{
    private List<ItemDeProyecto> tareas = new ArrayList<>();

    public void añadirTarea (ItemDeProyecto tarea){
        this.tareas.add(tarea);
    }
    public void quitarTarea (ItemDeProyecto tarea){
        this.tareas.remove(tarea);
    }

    @Override
    public int calcularTiempoNecesario() {
        int horasTotales = 0;
        for (ItemDeProyecto tarea : this.tareas){
            horasTotales += tarea.calcularTiempoNecesario();
        }
        return horasTotales;
    }
}
