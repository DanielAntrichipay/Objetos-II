package org.example;

import java.time.LocalDateTime;

public class ComarcaPlus extends TargetaDeCredito {
	private float descuento;

	public ComarcaPlus(String numero, String titular, LocalDateTime fechaDeExpiracion) throws RuntimeException {
		super(numero, titular, fechaDeExpiracion);
		this.descuento = 0.02F;
	}

	@Override
	public float aplicarDescuento(float totalBebidas, float totalPlatos) {
		float total = totalBebidas + totalPlatos;
		return total - (total * descuento);
	}
}
