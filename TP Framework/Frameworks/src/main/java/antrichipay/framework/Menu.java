package antrichipay.framework;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
    private static final String CLASS_NAME_PROPERTY = "clase";
    private List<Accion> listaDeAcciones = new ArrayList<>();

    public Menu(String pathDeConfiguracion) {
        Properties prop = new Properties();
        try (InputStream configFile = getClass().getResourceAsStream(pathDeConfiguracion);) {
            prop.load(configFile);
            String clase = prop.getProperty(CLASS_NAME_PROPERTY);

            String[] clases = clase.split("\\s*,\\s*");
            for (String nombreClase : clases) {
                Class c = Class.forName(nombreClase.trim());
                Accion accion = (Accion) c.getDeclaredConstructor().newInstance();
                this.listaDeAcciones.add(accion);
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    "No pude crear la instancia de Accion... " + e.getMessage());
        }
        imprimir();
    }

    public void imprimir (){
        int ultimoNumeroDeOpcion = 1;
        int opcionSeleccionada = 1;
        String menuDeOpciones = "";
        for (Accion accion : listaDeAcciones){
            menuDeOpciones += String.valueOf(ultimoNumeroDeOpcion) + " - " + accion.nombreItemMenu() + ": " + accion.descripcionItemMenu() + "." + System.lineSeparator();
            ultimoNumeroDeOpcion ++;
        }
        menuDeOpciones += String.valueOf(ultimoNumeroDeOpcion) + " - Salir." + System.lineSeparator();

        while ((opcionSeleccionada >= 1) && (opcionSeleccionada != ultimoNumeroDeOpcion)) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(menuDeOpciones);
            Scanner scanner = new Scanner(System.in);
            opcionSeleccionada = scanner.nextInt();

           if (opcionSeleccionada > ultimoNumeroDeOpcion){
               System.out.println("No es un valor valido.");
               opcionSeleccionada = 1;
           }
           else if (opcionSeleccionada != ultimoNumeroDeOpcion){
               listaDeAcciones.get(opcionSeleccionada -1).ejecutar();
           }
        }
    }
}
