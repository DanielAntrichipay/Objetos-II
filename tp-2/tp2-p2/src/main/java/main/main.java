package main;

import org.example.ItemDeAlimento;
import org.example.Menu;
import org.example.Mesa;

import persistencia.*;

public class main {

	public static void main(String[] args) {
		PersistirPrecioTotal persistencia = new PersistirLocalmente() /* CuentaDAOJDBC() */;

		Menu unMenu = new Menu();
		unMenu.agregarPlato(new ItemDeAlimento("Pastel de Papa", 200));
		unMenu.agregarBebida(new ItemDeAlimento("Agua", 100));

		int capacidadDeMesa = 4;
		int numeroDeMesa = 1;

		Mesa unaMesa = new Mesa(capacidadDeMesa, unMenu, numeroDeMesa, persistencia);

	}

}
