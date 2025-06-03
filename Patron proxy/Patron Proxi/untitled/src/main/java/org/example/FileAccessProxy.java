package org.example;

import java.io.IOException;

public class FileAccsessProxy extends Access{
    private FileAccess file;
    private Usuario usuario;

    public FileAccsessProxy(String nombreArchivo, String ruta, FileAccess file, Usuario usuario) {
        super(nombreArchivo, ruta);
        this.file = file;
        this.usuario = usuario;
    }

    @Override
    public String readFile() throws IOException {

        if (nombreArchivo.charAt(0) != 'i' && nombreArchivo.charAt(0) != 'm'){
            return file.readFile();
        }
        if (nombreArchivo.charAt(0) == 'i' && usuario.poseePermiso(Permiso.ADMIN)){
            return file.readFile();
        }
        else if (usuario.poseePermiso(Permiso.ADMIN) || usuario.poseePermiso(Permiso.INTERMEDIO)) {
            return file.readFile();
        }
        return "";
    }
}
