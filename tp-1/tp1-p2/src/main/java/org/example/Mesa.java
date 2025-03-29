package org.example;

public class Mesa {
	private int numeroDeMesa;
	private int capacidad;
	private Menu menu;
	private Pedido pedido;

	public Mesa(int capacidad, Menu menu, int numeroDeMesa) {
		this.capacidad = capacidad;
		this.menu = menu;
		this.numeroDeMesa = numeroDeMesa;
		this.pedido = new Pedido(this.numeroDeMesa);
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
		return pedido.calcularCostoTotal(unaTarjeta);
	}
}