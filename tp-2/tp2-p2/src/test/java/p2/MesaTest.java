package p2;

import org.junit.jupiter.api.Test;

import persistencia.PersistirLocalmente;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.example.*;

public class MesaTest {
	@Test
	public void calculoDelCostoConVisa() {
		try {
			var tarjetaVisa = new Visa("1234567890123456", "Pepito", LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(tarjetaVisa));
			assertEquals(297.0, mesa.consultarCostoTotal(tarjetaVisa));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void calculoDelCostoConMastercard() {
		try {
			var tarjetaMastercard = new Mastercard("1234567890123456", "Pepito", LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(tarjetaMastercard));
			assertEquals(296.0, mesa.consultarCostoTotal(tarjetaMastercard));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void calculoDelCostoConComarcaPlus() {
		try {
			var tarjetaComarcaPlus = new ComarcaPlus("1234567890123456", "Pepito",
					LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(tarjetaComarcaPlus));
			assertEquals(294.0, mesa.consultarCostoTotal(tarjetaComarcaPlus));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void calculoDelCostoConsTargetaViedma() {
		try {
			var tarjetaViedma = new TarjetaSinDescuento("1234567890123456", "Pepito",
					LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(tarjetaViedma));
			assertEquals(300.0, mesa.consultarCostoTotal(tarjetaViedma));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private Mesa instanciarMesa() {
		int capacidadDeMesa = 4;
		int numeroDeMesa = 1;
		var menu = instanciarMenu();
		var persistencia = new PersistirLocalmente();
		return new Mesa(capacidadDeMesa, menu, numeroDeMesa, persistencia);
	}

	private Menu instanciarMenu() {
		Menu unMenu = new Menu();
		unMenu.agregarPlato(new ItemDeAlimento("Pastel de Papa", 200));
		unMenu.agregarBebida(new ItemDeAlimento("Agua", 100));
		return unMenu;
	}

}
