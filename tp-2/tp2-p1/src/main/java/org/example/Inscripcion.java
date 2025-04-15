package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inscripcion {
	private static final String ID_CONCURSO_VACÍO = "EL ID del concurso esta vacío.";

	private LocalDateTime fechaDeCreacion;
	private String idConcurso;
	private Participante participante;

	public Inscripcion(Participante participante) {
		this.fechaDeCreacion = LocalDateTime.now();
		this.participante = participante;
	}

	public void agregarIdConcurso(String idConcurso) {
		this.checkIdConcurso(idConcurso);
		this.idConcurso = idConcurso;
	}

	public LocalDateTime consultarFechaDeCreacion() {
		LocalDateTime fechaDeCreacionCopia = this.fechaDeCreacion;
		return fechaDeCreacionCopia;
	}

	public Participante consultarParticipante() {
		return this.participante;
	}

	public String obtenerInscripcionFormateada() {
		return fechaDeCreacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", " + participante.getId() + ", "
				+ this.idConcurso;
	}

	private void checkIdConcurso(String idConcurso) {
		if (idConcurso.isBlank() || idConcurso.isEmpty()) {
			throw new RuntimeException(ID_CONCURSO_VACÍO);
		}
	}

	public String obtenerIdUsuario() {
		return this.participante.getId();
	}

	public String obtenerIdConcurso() {
		return this.idConcurso;
	}
}