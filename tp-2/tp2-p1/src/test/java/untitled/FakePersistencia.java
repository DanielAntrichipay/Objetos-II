package untitled;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.example.Inscripcion;

import Persistencia.PersistirInscriptos;

public class FakePersistencia implements PersistirInscriptos{
	private static final String NO_SE_PUDO_CREAR_EL_ARCHIVO = "No se pudo crear el archivo.";
	private static final String ARCHIVO_YA_EXISTE = "El archivo ya existe!";
	private Path path = Paths.get("recursos/FakeInscriptos.txt");

	public FakePersistencia() {

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
	public void persistirUnInscripto(Inscripcion inscripcion) {
		try {
			Files.write(this.path, (inscripcion.obtenerInscripcionFormateada() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
			throw new RuntimeException(NO_SE_PUDO_CREAR_EL_ARCHIVO);
		}
	}
}
