package untitled;

import org.junit.jupiter.api.Test;

import Persistencia.PersistirLocalmente;
import servicios.CorreoElectronico;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.example.Concurso;
import org.example.Participante;

public class ConcursoTest {
	private LocalDateTime fechaDeInicio = LocalDateTime.now();
	private LocalDateTime fechaDeFin = fechaDeInicio.plusMonths(2);

	@Test
	public void inscripcionAlConcursoTest() {
		FakeCorreo correo;
		var participante = new Participante("Pepito", "Pescador", "pepitoPescador@gmail.com", "#001");
		var concurso = new Concurso("Concurso de Pesca", this.fechaDeInicio, this.fechaDeFin, "#001",  new FakePersistencia());
		concurso.inscripcionNueva(participante.crearInscripcion());
		if (concurso.estaInscripto(participante)){
			correo = new FakeCorreo ();
			correo.enviarNotificacion(participante.getCorreo(), "Inscripcion a concurso", ("Felicidades!! Estas inscripto al concurso " + concurso.getNombre()));
		}
		assertTrue(concurso.estaInscripto(participante));
	}

	@Test
	public void inscripcionAlConcursoEnElPrimerDiaTest() {
		FakeCorreo correo;
		var participante = new Participante("Magnus", "Calsen", "magnusCalsen@gmail.com", "#002");
		var concurso = new Concurso("Concurso de Ajedrez", this.fechaDeInicio, this.fechaDeFin, "#002",  new FakePersistencia());
		concurso.inscripcionNueva(participante.crearInscripcion());
		if (concurso.estaInscripto(participante)){
			correo = new FakeCorreo ();
			correo.enviarNotificacion(participante.getCorreo(), "Inscripcion a concurso", ("Felicidades!! Estas inscripto al concurso " + concurso.getNombre()));
		}
		assertTrue(concurso.estaInscripto(participante));
	}

	@Test
	public void inscripcionAlConcursoFueraDelRangoqDeInscripcionTest() {
		FakeCorreo correo;
		var participante = new Participante("Magnus", "Calsen", "magnusCalsen@gmail.com", "#003");
		var concurso = new Concurso("Concurso de Ajedrez", LocalDateTime.of(2000, 01, 01, 00, 00),
				LocalDateTime.of(2000, 02, 01, 00, 00), "#003",  new FakePersistencia());
		if (concurso.estaInscripto(participante)){
			correo = new FakeCorreo ();
			correo.enviarNotificacion(participante.getCorreo(), "Inscripcion a concurso", ("Felicidades!! Estas inscripto al concurso " + concurso.getNombre()));
		}

		assertThrows(RuntimeException.class, () -> {
			concurso.inscripcionNueva(participante.crearInscripcion());
		});
	}

	@Test
	public void formatoTextoDeInscripcion() {
		FakeCorreo correo;
		var participante = new Participante("Pepito", "Pescador", "pepitoPescador@gmail.com", "#004");
		var concurso = new Concurso("Concurso de Pesca", this.fechaDeInicio, this.fechaDeFin, "#004",  new FakePersistencia());
		concurso.inscripcionNueva(participante.crearInscripcion());
		if (concurso.estaInscripto(participante)){
			correo = new FakeCorreo ();
			correo.enviarNotificacion(participante.getCorreo(), "Inscripcion a concurso", ("Felicidades!! Estas inscripto al concurso " + concurso.getNombre()));
		}
		assertEquals(concurso.recuperarInscripcion(participante).obtenerInscripcionFormateada(),
				(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", #004, #004"));
	}
}
