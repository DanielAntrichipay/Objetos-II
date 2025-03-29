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
/*
 * --------------------- LAMBDA --------------------- 26/MAR/25. BASE: UN TIPO
 * DE DATO ES CONJUNTO DE VALORES QUE ENTRAN EN UNA VARIABLE. DESTRAS DE UN
 * LAMDA HAY UNA INTERFAZ. UN TIPO ES AQUELLO QUE SOPORTA UN COMPORTAMIENTO. VAR
 * SOLO SE USA CUANDO EL COMPILADOR PUEDE DETERMINAR DE QUE TIPO ES
 * (¿INSTANCIAS?, PARAMETROS) ¿COMO LO DETERMINA? CLASE ANONIMA ???
 * 
 * DESARROLLO: NO ENTENDI LO DE LOS TIPOS. CALUSURA EN INGLES -> CONSEPTO NUEVO.
 * BILDEAR VARIABLES??? SCOPE??? UNA LAMBDA ES UNA LASE ANONIMA??? LAMBDA VIVE
 * EN UN AMBITO Y NO PUEDE MODIFICAR LAS VARIABLES DEL MISMO, PERO SI USARLAS.
 * EXTRACT METHOD -> EXTRAE CODIGO DE UN METODO EN OTROS METODOS PRIVADOS. TEXTO
 * DUPLICADO -> EXTRICTAMENTE EL TEXTO. CODIGO DUPLICADO -> ESTRUCTURA DE CODIGO
 * DUPLICADA. SMALLTO NOTA: GTW VA CON UN PLUGGIN PARA LA COMPILACION A HTML,
 * CSS, JS
 */