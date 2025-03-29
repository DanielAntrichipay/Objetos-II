package org.example;

import java.time.LocalDateTime;

public class TarjetaSinDescuento extends TarjetaDeCredito {

	public TarjetaSinDescuento(String numero, String titular, LocalDateTime fechaDeExpiracion) throws RuntimeException {
		super(numero, titular, fechaDeExpiracion);
	}

	@Override
	public float aplicarDescuento(float totalBebidas, float totalPlatos) {
		return totalBebidas + totalPlatos;
	}
}
