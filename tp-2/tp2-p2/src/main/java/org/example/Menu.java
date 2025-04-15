package org.example;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<ItemDeAlimento> listaDePlatos = new ArrayList <ItemDeAlimento>();
	private List<ItemDeAlimento> listaDeBebidas = new ArrayList <ItemDeAlimento>();

	public void agregarBebida(ItemDeAlimento nuevaBebida) {
		this.listaDeBebidas.add(nuevaBebida);
	}

	public void agregarPlato(ItemDeAlimento nuevoPlato) {
		this.listaDePlatos.add(nuevoPlato);
	}

	public List<ItemDeAlimento> obtenerListaDeBebidas() {
		return List.copyOf(this.listaDeBebidas);
	}

	public List<ItemDeAlimento> obtenerListaDePlatos() {
		return List.copyOf(this.listaDePlatos);
	}
}