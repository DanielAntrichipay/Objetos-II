package P4;

import java.util.ArrayList;
import java.util.List;

public class LogTransaction {
    private List<String> registro = new ArrayList<>();

    public void log (String dato){
        registro.add(dato);
    }
}
