package org.example;

import java.time.LocalDateTime;

public abstract class TarjetaDeCredito {
	public static final String NUMERO_VACIO = "El número no puede ser vacío";
	public static final String NUMERO_TARJETA_NO_VALIDO = "El número debe tener 16 dígitos";
	public static final String TITULAR_VACIO = "El titular no puede ser vacío";
	public static final String TARGETA_EXPIRADA = "La tarjeta está vencida";
	private String numero;
	private String titular;
	private LocalDateTime fechaDeExpiracion;

	public TarjetaDeCredito(String numero, String titular, LocalDateTime fechaDeExpiracion)
			throws RuntimeException {
		this.chequearNumero(numero);
		this.chequearTitular(titular);
		this.chequearFchaDeExpiracion(fechaDeExpiracion);
		this.numero = numero;
		this.titular = titular;
		this.fechaDeExpiracion = fechaDeExpiracion;
	}

	private void chequearNumero(String numero) {
		if (numero.isBlank()) {
			throw new RuntimeException(this.NUMERO_VACIO);
		}
		if (numero.length() != 16) {
			throw new RuntimeException(this.NUMERO_TARJETA_NO_VALIDO);
		}
	}

	private void chequearTitular(String titular) {
		if (titular.isBlank()) {
			throw new RuntimeException(this.TITULAR_VACIO);
		}
	}

	private void chequearFchaDeExpiracion(LocalDateTime fechaDeExpiracion) {
		if (fechaDeExpiracion.isAfter(LocalDateTime.now())) {
			throw new RuntimeException(this.TARGETA_EXPIRADA);
		}
	}

	public abstract float aplicarDescuento(float totalBebidas, float totalPlatos);
}
