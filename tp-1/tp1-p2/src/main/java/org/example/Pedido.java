package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int numeroDeMesaPerteneciente;
	private List<ItemDeAlimento> listaDePlatos = new ArrayList();
	private List<ItemDeAlimento> listaDeBebidas = new ArrayList();
	private int precioTotalBebidas;
	private int precioTotalPlatos;
	private boolean estadoDelPago = false;

	public Pedido(int numeroDeMesaPerteneciente) {
		this.numeroDeMesaPerteneciente = numeroDeMesaPerteneciente;
	}

	public int consultarMesaPerteneciente() {
		return this.numeroDeMesaPerteneciente;
	}

	public void agregarPlato(ItemDeAlimento plato) {
		this.precioTotalPlatos += plato.obtenerPrecio();
		this.listaDePlatos.add(plato);
	}

	public void agregarBebida(ItemDeAlimento bebida) {
		this.precioTotalBebidas += bebida.obtenerPrecio();
		this.listaDeBebidas.add(bebida);
	}

	public boolean estaPago() {
		return this.estadoDelPago;
	}

	public float calcularCostoTotal(TargetaDeCredito unaTargeta) {
		return unaTargeta.aplicarDescuento(this.precioTotalBebidas, this.precioTotalPlatos);
	}
}