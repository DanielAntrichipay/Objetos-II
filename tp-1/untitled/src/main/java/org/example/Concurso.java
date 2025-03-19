package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
	private String nombre;
	private LocalDateTime fechaInicialDeInscripcion;
	private LocalDateTime fechaFinalDeInscripcion;
	private List<Participante> listaDeParticipantesInscriptos = new ArrayList<Participante>();

	public Concurso(LocalDateTime fechaInicialDeInscripcion, LocalDateTime fechaFinalDeInscripcion, String nombre) {
		this.fechaInicialDeInscripcion = fechaInicialDeInscripcion;
		this.fechaFinalDeInscripcion = fechaFinalDeInscripcion;
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void inscripcionNueva(Participante participante) {
		LocalDateTime fechaActual = LocalDateTime.now();
		System.out.println(fechaActual.toString());
		System.out.println(fechaInicialDeInscripcion.toString());
		System.out.println(fechaFinalDeInscripcion.toString());
		if (fechaEstaEnRangoDeInscripcion (fechaActual)) {
			this.listaDeParticipantesInscriptos.add(participante);
		}
	}

	public boolean estaInscripto(Participante unParticipante) {
		return this.listaDeParticipantesInscriptos.stream()
				.anyMatch(otroParticipante -> unParticipante.equals(otroParticipante));
	}
	
	private boolean fechaEstaEnRangoDeInscripcion(LocalDateTime FechaEvaluada) {
		if (FechaEvaluada.isEqual(this.fechaInicialDeInscripcion) || (FechaEvaluada.isAfter(this.fechaInicialDeInscripcion)
				&& FechaEvaluada.isBefore(this.fechaFinalDeInscripcion))) {
			return true;
		}
		return false;
	}
}
