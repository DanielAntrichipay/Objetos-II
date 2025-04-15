package untitled;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import servicios.NotificarInscripcion;

public class FakeCorreo implements NotificarInscripcion{
	private static final String NO_SE_PUDO_CREAR_EL_ARCHIVO = "No se pudo crear el archivo.";
	private static final String ARCHIVO_YA_EXISTE = "El archivo ya existe!";
	private Path path = Paths.get("recursos/Correos.txt");
	
	public FakeCorreo (){
		try {
			if (!Files.exists(path)) {
				Files.createFile(path);
			}
	
		} catch (FileAlreadyExistsException e) {
			throw new RuntimeException(ARCHIVO_YA_EXISTE);
		} catch (IOException e) {
			throw new RuntimeException(NO_SE_PUDO_CREAR_EL_ARCHIVO);
		}
	}
	@Override
	public void enviarNotificacion(String destino, String asunto, String mensaje) {
		String correo = "Remitente: fakeCorreo@correo.com" + System.lineSeparator() 
						+ "Destinatario: " + destino +  System.lineSeparator()
						+ "Asunto: " + asunto +  System.lineSeparator()
						+ "" +  System.lineSeparator()
						+ mensaje + System.lineSeparator()
						+ "---------------------------------------------------------------" 
						+ System.lineSeparator() + System.lineSeparator();
		try {
			Files.write(this.path, correo.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(NO_SE_PUDO_CREAR_EL_ARCHIVO);
		}
	}
}
