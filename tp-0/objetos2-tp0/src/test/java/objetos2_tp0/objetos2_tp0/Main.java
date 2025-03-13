package objetos2_tp0.objetos2_tp0;

public class Main {

	public static void main(String[] args) {
		Tiempo tiempoActual = new Tiempo();

		System.out.println(tiempoActual.FormatoCorto());
		System.out.println(tiempoActual.FormatoLargo());
		
		System.out.println("");
		
		TiempoAnemico tiempoActualAnemico = new TiempoAnemico ();
		
		System.out.println(tiempoActual.FormatoCorto());
		System.out.println(tiempoActual.FormatoLargo());
	}

}
