package org.example;

public class ItemDeAlimento {
	private String nombre;
	private int precio;

	public ItemDeAlimento(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int obtenerPrecio() {
		return this.precio;
	}

	public boolean equals(ItemDeAlimento unItemDeAlimento) {
		return (this.nombre.equalsIgnoreCase(unItemDeAlimento.getNombre()))
				&& (this.precio == unItemDeAlimento.obtenerPrecio());
	}
}