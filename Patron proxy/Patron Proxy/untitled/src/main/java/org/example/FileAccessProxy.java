package org.example;

import java.io.IOException;

public class FileAccessProxy extends Access{
    private FileAccess file;
    private Usuario usuario;

    public FileAccessProxy(String nombreArchivo, String ruta, FileAccess file, Usuario usuario) {
        super(nombreArchivo, ruta);
        this.file = file;
        this.usuario = usuario;
    }

    @Override
    public String readFile() throws IOException {

        if (nombreArchivo.charAt(0) != 'I' && nombreArchivo.charAt(0) != 'M'){
            return file.readFile();
        }
        if (nombreArchivo.charAt(0) == 'M' && (usuario.poseePermiso(Permiso.ADMIN) || usuario.poseePermiso(Permiso.INTERMEDIO))){
            return file.readFile();
        }
        else if (this.usuario.poseePermiso(Permiso.ADMIN)) {
            return file.readFile();
        }
        return "No posees los permisos para ver este archivo.";
    }
}
