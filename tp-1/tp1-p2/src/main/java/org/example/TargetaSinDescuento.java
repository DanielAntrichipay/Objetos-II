package org.example;

import java.time.LocalDateTime;

public class TargetaSinDescuento extends TargetaDeCredito {

	public TargetaSinDescuento(String numero, String titular, LocalDateTime fechaDeExpiracion) throws RuntimeException {
		super(numero, titular, fechaDeExpiracion);
	}

	@Override
	public float aplicarDescuento(float totalBebidas, float totalPlatos) {
		return totalBebidas + totalPlatos;
	}
}
