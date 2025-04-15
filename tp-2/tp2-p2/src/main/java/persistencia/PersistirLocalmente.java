package persistencia;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersistirLocalmente implements PersistirPrecioTotal {
	private static final String NO_SE_PUDO_CREAR_EL_ARCHIVO = "No se pudo crear el archivo.";
	private static final String ARCHIVO_YA_EXISTE = "El archivo ya existe!";
	private Path path = Paths.get("recursos/Precios.txt");

	public PersistirLocalmente() {
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
	public void persistirCuenta(float costoTotal) {

		try {
			Files.write(this.path,
					(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", "
							+ String.valueOf(costoTotal) + System.lineSeparator()).getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(NO_SE_PUDO_CREAR_EL_ARCHIVO);
		}
	}

}