package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Lector {
    private String path;

    public Lector(String path) {
        this.path = path;
    }

    public List<String[]> recuperarFila (){
        try {
            List<String[]> csvData = new ArrayList<String[]>();
            CSVReader reader = null;
            reader = new CSVReader(new FileReader(this.path /*"src/main/resources/data.csv"*/));

            String[] row = null;

            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }

            reader.close();
            csvData.remove(0);
            return csvData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
