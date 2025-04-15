package org.example;

public class Participante {
	private static final String CORREO_VACIO = "El correo no puede estar vacío.";
	private static final String APELLIDO_VACIO = "El apellido no puede estar vacío.";
	private static final String NOMBRE_VACIO = "El nombre no puede estar vacío.";
	private String Id;
	private String nombre;
	private String apellido;
	private String correo;

	public Participante(String nombre, String apellido, String correo, String Id) {
		this.checkNombre(nombre);
		this.checkApellido(apellido);
		this.checkCorreo(correo);
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.Id = Id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public String obtenerNombreCompleto() {
		return this.apellido + ", " + this.nombre;
	}

	public Inscripcion crearInscripcion() {
		return new Inscripcion(this);
	}

	public String getId() {
		return this.Id;
	}

	public boolean equals(Participante participante) {
		return this.Id.equalsIgnoreCase(participante.getId());
	}

	private void checkNombre(String nombre) {
		if (nombre.isBlank() || nombre.isEmpty()) {
			throw new RuntimeException(NOMBRE_VACIO);
		}
	}

	private void checkApellido(String apellido) {
		if (apellido.isBlank() || apellido.isEmpty()) {
			throw new RuntimeException(APELLIDO_VACIO);
		}
	}

	private void checkCorreo(String correo) {
		if (correo.isBlank() || correo.isEmpty()) {
			throw new RuntimeException(CORREO_VACIO);
		}
	}

}
