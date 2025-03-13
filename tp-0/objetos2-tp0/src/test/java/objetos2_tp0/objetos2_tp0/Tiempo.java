package objetos2_tp0.objetos2_tp0;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.LocalDateTime;

public class Tiempo {
	LocalDateTime Tiempo;

	public Tiempo() {
		this.Tiempo = LocalDateTime.now();
	}

	public String FormatoCorto() {
		return Tiempo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String FormatoLargo() {
		return Tiempo.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
	}
}
