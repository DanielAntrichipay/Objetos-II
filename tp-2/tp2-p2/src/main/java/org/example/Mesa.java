package org.example;

import persistencia.*;

public class Mesa {
	PersistirPrecioTotal PersistenciaDeCuentas;
	private int numeroDeMesa;
	private int capacidad;
	private Menu menu;
	private Pedido pedido;

	public Mesa(int capacidad, Menu menu, int numeroDeMesa, PersistirPrecioTotal Percistencia) {
		this.capacidad = capacidad;
		this.menu = menu;
		this.numeroDeMesa = numeroDeMesa;
		this.pedido = new Pedido(this.numeroDeMesa);
		this.PersistenciaDeCuentas = Percistencia;
	}

	public int getCapacidads() {
		return this.capacidad;
	}

	public Menu consultarMenu() {
		return this.menu;
	}

	public void agregarBebidaAlPedido(ItemDeAlimento bebida) {
		this.pedido.agregarBebida(bebida);
	}

	public void agregarPlatoAlPedido(ItemDeAlimento plato) {
		this.pedido.agregarPlato(plato);
	}

	public Pedido consultarPedido() {
		return this.pedido;
	}

	public float consultarCostoTotal(TarjetaDeCredito unaTarjeta) {
		float costoTotal = pedido.calcularCostoTotal(unaTarjeta);
		PersistenciaDeCuentas.persistirCuenta(costoTotal);
		return costoTotal;
	}
}