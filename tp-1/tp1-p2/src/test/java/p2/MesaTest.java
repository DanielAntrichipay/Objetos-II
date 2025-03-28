package p2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.example.*;

public class MesaTest {
	@Test
	public void calculoDelCostoConVisa() {
		try {
			var targetaVisa = new Visa("1234567890123456", "Pepito", LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(targetaVisa));
			assertEquals(297.0, mesa.consultarCostoTotal(targetaVisa));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void calculoDelCostoConMastercard() {
		try {
			var targetaMastercard = new Mastercard("1234567890123456", "Pepito", LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(targetaMastercard));
			assertEquals(296.0, mesa.consultarCostoTotal(targetaMastercard));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void calculoDelCostoConComarcaPlus() {
		try {
			var targetaComarcaPlus = new ComarcaPlus("1234567890123456", "Pepito",
					LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(targetaComarcaPlus));
			assertEquals(294.0, mesa.consultarCostoTotal(targetaComarcaPlus));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void calculoDelCostoConsTargetaViedma() {
		try {
			var TargetaViedma = new TargetaSinDescuento("1234567890123456", "Pepito",
					LocalDateTime.of(2025, 1, 1, 00, 00));
			int primerBebida = 0;
			int primerPlato = 0;
			var mesa = instanciarMesa();
			var menu = mesa.consultarMenu();
			mesa.agregarBebidaAlPedido(menu.obtenerListaDeBebidas().get(primerBebida));
			mesa.agregarPlatoAlPedido(menu.obtenerListaDePlatos().get(primerPlato));
			System.out.println(mesa.consultarCostoTotal(TargetaViedma));
			assertEquals(300.0, mesa.consultarCostoTotal(TargetaViedma));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private Mesa instanciarMesa() {
		int capacidadDeMesa = 4;
		int numeroDeMesa = 1;
		var menu = instanciarMenu();
		return new Mesa(capacidadDeMesa, menu, numeroDeMesa);
	}

	private Menu instanciarMenu() {
		Menu unMenu = new Menu();
		unMenu.agregarPlato(new ItemDeAlimento("Pastel de Papa", 200));
		unMenu.agregarBebida(new ItemDeAlimento("Agua", 100));
		return unMenu;
	}

}
