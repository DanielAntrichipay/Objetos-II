package org.example;

public class Participante {
	private String nombre;
	private String apellido;
	private String correo;

	public Participante(String nombre, String apellido, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}
	
	private String getCorreo() {
		return this.correo;
	}

	public String obtenerNombreCompleto() {
		return this.apellido + ", " + this.nombre;
	}

	public void inscribierseEnConcurso(Concurso unConcurso) {
		unConcurso.inscripcionNueva(this);
	}

	public boolean equals(Participante participante) {
		return this.correo.equalsIgnoreCase(participante.getCorreo ());
	}
}
