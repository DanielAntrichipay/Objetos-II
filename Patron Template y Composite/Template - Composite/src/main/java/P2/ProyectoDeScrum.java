package P2;

import java.util.ArrayList;
import java.util.List;

public class ProyectoDeScrum {
    private List<ItemDeProyecto> itemsDeProyecto = new ArrayList<>();

    public void aniadirItem (ItemDeProyecto item){
        itemsDeProyecto.add(item);
    }
}
