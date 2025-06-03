package org.p2;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static final String FILE_NAME = "Importante.txt";
    public static final String RUTA = "recursos";

    public static void main(String[] args) {
        List<Permiso> listaPermisos = new ArrayList<>();
        listaPermisos.add(Permiso.ADMIN);
        var usuario = new Usuario("Pedrito", listaPermisos);
        var file = new FileAccess(FILE_NAME, RUTA);
        FileAccessProxy fileProxy = new FileAccessProxy(FILE_NAME, RUTA, file, usuario);
        try {
            System.out.println(fileProxy.readFile());
        } catch (IOException e) {
            System.out.println("no se encontro el archivo");
        }
    }

}