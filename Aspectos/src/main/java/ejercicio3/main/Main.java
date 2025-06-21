package ejercicio3.main;

import ejercicio3.Persistencia.ArchivoDeTexto;
import ejercicio3.Modelo.Concursos;
import ejercicio3.UI.VentanaInscriptos;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        new VentanaInscriptos(new Concursos(new ArchivoDeTexto("src/main/java/ejercicio3/RegistroDeInscriptos")));
        //new VentanaInscriptos(new Concursos(new JdbcRegistroDeInscriptos()));

    }
}


