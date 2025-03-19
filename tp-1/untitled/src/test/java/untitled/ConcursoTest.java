package untitled;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.example.Concurso;
import org.example.Participante;

public class ConcursoTest {
	@Test
	public void inscripcionAlConcursoTest() {
		LocalDateTime fechaInicialDeInscripcion = LocalDateTime.of(2025, 1, 25, 00, 00);
		LocalDateTime fechaFinalDeInscripcion = LocalDateTime.of(2026, 1, 25, 00, 00);
		Concurso unConcurso = new Concurso(fechaInicialDeInscripcion, fechaFinalDeInscripcion, "Cocurso N°.1");
		Participante unParticipante = new Participante("Jose", "Rozen", "jrozen@gmail.com");

		unParticipante.inscribierseEnConcurso(unConcurso);

		assertTrue(unConcurso.estaInscripto(unParticipante));
	}

	@Test
	public void inscripcionAlConcursoEnElPrimerDiaTest() {
		LocalDateTime fechaInicialDeInscripcion = LocalDateTime.now();
		LocalDateTime fechaFinalDeInscripcion = LocalDateTime.of(2026, 1, 25, 00, 00);
		Concurso unConcurso = new Concurso(fechaInicialDeInscripcion, fechaFinalDeInscripcion, "Cocurso N°.1");
		Participante unParticipante = new Participante("Jose", "Rozen", "jrozen@gmail.com");

		unParticipante.inscribierseEnConcurso(unConcurso);

		assertTrue(unConcurso.estaInscripto(unParticipante));
	}

	@Test
	public void inscripcionAlConcursoFueraDelRangoDeInscripcionTest() {
		LocalDateTime fechaInicialDeInscripcion = LocalDateTime.of(2020, 1, 25, 00, 00);
		LocalDateTime fechaFinalDeInscripcion = LocalDateTime.of(2021, 1, 25, 00, 00);
		Concurso unConcurso = new Concurso(fechaInicialDeInscripcion, fechaFinalDeInscripcion, "Cocurso N°.1");
		Participante unParticipante = new Participante("Jose", "Rozen", "jrozen@gmail.com");

		unParticipante.inscribierseEnConcurso(unConcurso);

		assertFalse(unConcurso.estaInscripto(unParticipante));
	}
}
