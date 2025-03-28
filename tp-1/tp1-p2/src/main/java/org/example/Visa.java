package org.example;

import java.time.LocalDateTime;

public class Visa extends TargetaDeCredito {
	private float descuento;

	public Visa(String numero, String titular, LocalDateTime fechaDeExpiracion) throws RuntimeException {
		super(numero, titular, fechaDeExpiracion);
		this.descuento = 0.03F;
	}

	@Override
	public float aplicarDescuento(float totalBebidas, float totalPlatos) {
		return totalPlatos + (totalBebidas - (totalBebidas * descuento));
	}
}
