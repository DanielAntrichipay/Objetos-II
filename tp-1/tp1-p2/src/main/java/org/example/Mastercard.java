package org.example;

import java.time.LocalDateTime;

public class Mastercard extends TargetaDeCredito {
	private float descuento;

	public Mastercard(String numero, String titular, LocalDateTime fechaDeExpiracion) throws RuntimeException {
		super(numero, titular, fechaDeExpiracion);
		this.descuento = 0.02F;
	}

	@Override
	public float aplicarDescuento(float totalBebidas, float totalPlatos) {
		return totalBebidas + (totalPlatos - (totalPlatos * descuento));
	}
}
