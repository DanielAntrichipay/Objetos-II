package org.p2;

import java.io.IOException;

public abstract class Access {
    String ruta;
    String nombreArchivo;

    public Access(String nombreArchivo, String ruta) {
        this.nombreArchivo = nombreArchivo;
        this.ruta = ruta;
    }

    public abstract String readFile() throws IOException;
}
