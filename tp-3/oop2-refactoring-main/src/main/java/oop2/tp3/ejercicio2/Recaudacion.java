package oop2.tp3.ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    public static final String COMPANY_NAME = "company_name";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ROUND = "round";
    public static final int NUMERO_DE_COLUMNA_COMPANY_NAME = 1;
    public static final int NUMERO_DE_COLUMNA_CITY = 4;
    public static final int NUMERO_DE_COLUMNA_STATE = 5;
    public static final int NUMERO_DE_COLUMNA_ROUN = 9;
    private List<String[]> datos;

    public Recaudacion(Lector lectorDeCSVs) {
        this.datos = lectorDeCSVs.recuperarFila();
    }

    public List<Map<String, String>> where(Map<String, String> options) throws IOException {
        filtrarPorColumna(options, COMPANY_NAME, NUMERO_DE_COLUMNA_COMPANY_NAME);
        filtrarPorColumna(options, CITY, NUMERO_DE_COLUMNA_CITY);
        filtrarPorColumna(options, STATE, NUMERO_DE_COLUMNA_STATE);
        filtrarPorColumna(options, ROUND, NUMERO_DE_COLUMNA_ROUN);

        return mapear();
    }

    private List<Map<String, String>> mapear() {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (int i = 0; i < this.datos.size(); i++) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put("permalink", this.datos.get(i)[0]);
            mapped.put(COMPANY_NAME, this.datos.get(i)[NUMERO_DE_COLUMNA_COMPANY_NAME]);
            mapped.put("number_employees", this.datos.get(i)[2]);
            mapped.put("category", this.datos.get(i)[3]);
            mapped.put(CITY, this.datos.get(i)[NUMERO_DE_COLUMNA_CITY]);
            mapped.put(STATE, this.datos.get(i)[NUMERO_DE_COLUMNA_STATE]);
            mapped.put("funded_date", this.datos.get(i)[6]);
            mapped.put("raised_amount", this.datos.get(i)[7]);
            mapped.put("raised_currency", this.datos.get(i)[8]);
            mapped.put(ROUND, this.datos.get(i)[NUMERO_DE_COLUMNA_ROUN]);
            output.add(mapped);
        }
        return output;
    }

    private void filtrarPorColumna(Map<String, String> options, String nombreColumna, int numeroDeColumna) {
        if (options.containsKey(nombreColumna)) {
            List<String[]> results = new ArrayList<String[]>();

            for (String[] dato : this.datos) {
                if (dato[numeroDeColumna].equals(options.get(nombreColumna))) {
                    results.add(dato);
                }
            }
            this.datos = results;
        }
    }
}
