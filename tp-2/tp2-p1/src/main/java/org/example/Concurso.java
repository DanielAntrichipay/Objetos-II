package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Persistencia.InscripcionDAOJDBC;
import Persistencia.PersistirInscriptos;
import Persistencia.PersistirLocalmente;

public class Concurso {
	private static final String INSCRIPCION_FUERA_DEL_PERIODO_DE_INSCRIPCION = "La inscripcion esta fuera del periodo de inscripcion.";
	private static final String PARTICIPANTE_YA_INSCRIPTO = "El participante ya esta inscripto.";
	private static final String NOMBRE_CONCURSO_VACIO = "El nombre del concurso esta vacío.";
	private static final String FECHA_INICIAL_POSTERIOR_A_DOS_AÑOS = "La fecha inicial es posterior a dos años.";
	private static final String LA_FECHA_INCIAL_POSTERIOR_A_FECHA_FINAL = "La fecha incial del concurso es posterior a la fecha final del mismo.";

	private PersistirInscriptos persistirInscriptos;
	private String id;
	private String nombre;
	private LocalDateTime fechaInicialDeInscripcion;
	private LocalDateTime fechaFinalDeInscripcion;
	private List<Inscripcion> listaDeInscripciones = new ArrayList<Inscripcion>();

	public Concurso(String nombre, LocalDateTime fechaInicialDeInscripcion, LocalDateTime fechaFinalDeInscripcion,
			String idConcurso, PersistirInscriptos persistencia) {
		this.checkPeriodoDeInscripcion(fechaInicialDeInscripcion, fechaFinalDeInscripcion);
		this.checkNombreDeConcurso(nombre);
		this.fechaInicialDeInscripcion = fechaInicialDeInscripcion;
		this.fechaFinalDeInscripcion = fechaFinalDeInscripcion;
		this.nombre = nombre;
		this.id = idConcurso;
		this.persistirInscriptos = persistencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void inscripcionNueva(Inscripcion nuevaInscripcion) {
		this.checkInscripcion(nuevaInscripcion);
		this.checkInscripcionEnPeriodoDeInscripcion(nuevaInscripcion);
		nuevaInscripcion.agregarIdConcurso(this.id);
		this.listaDeInscripciones.add(nuevaInscripcion);
		persistirInscriptos.persistirUnInscripto(nuevaInscripcion);
	}

	public boolean estaInscripto(Participante unParticipante) {
		return this.listaDeInscripciones.stream().map(Inscripcion::consultarParticipante)
				.anyMatch(unParticipante::equals);
	}

	private void checkNombreDeConcurso(String nombreDeConcurso) {
		if (nombreDeConcurso.isBlank() || nombreDeConcurso.isEmpty()) {
			throw new RuntimeException(NOMBRE_CONCURSO_VACIO);
		}
	}

	private void checkInscripcion(Inscripcion nuevaInscripcion) {
		if (this.estaInscripto(nuevaInscripcion.consultarParticipante())) {
			throw new RuntimeException(PARTICIPANTE_YA_INSCRIPTO);
		}

	}

	private void checkInscripcionEnPeriodoDeInscripcion(Inscripcion inscripcion) {
		if (inscripcion.consultarFechaDeCreacion().isAfter(this.fechaFinalDeInscripcion)) {
			throw new RuntimeException(INSCRIPCION_FUERA_DEL_PERIODO_DE_INSCRIPCION);
		}
		if (inscripcion.consultarFechaDeCreacion().isBefore(this.fechaInicialDeInscripcion)) {
			throw new RuntimeException(INSCRIPCION_FUERA_DEL_PERIODO_DE_INSCRIPCION);
		}
	}

	private void checkPeriodoDeInscripcion(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		if (fechaInicial.isAfter(fechaFinal)) {
			throw new RuntimeException(LA_FECHA_INCIAL_POSTERIOR_A_FECHA_FINAL);
		} else if (fechaInicial.isAfter(LocalDateTime.now().plusYears(2))) {
			throw new RuntimeException(FECHA_INICIAL_POSTERIOR_A_DOS_AÑOS);
		}
	}

	public Inscripcion recuperarInscripcion(Participante participante) {
		return this.listaDeInscripciones.stream()
				.filter(inscripcion -> inscripcion.consultarParticipante().equals(participante)).findFirst()
				.orElseThrow(() -> new RuntimeException("No se encontró inscripción para el participante"));
	}
}
