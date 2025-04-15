package Main;

import Persistencia.PersistirInscriptos;
import Persistencia.PersistirLocalmente;
import servicios.CorreoElectronico;

import java.time.LocalDateTime;

import org.example.Concurso;
import org.example.Participante;

import Persistencia.InscripcionDAOJDBC;

public class Main {

	public static void main(String[] args) {
		PersistirInscriptos persistencia = new PersistirLocalmente()/* InscripcionDAOJDBC */;
		CorreoElectronico correo;
		
		var participante = new Participante("Pepito", "Pescador", "pepitoPescador@gmail.com", "#001");
		var concurso = new Concurso("Concurso de Pesca", LocalDateTime.now(), LocalDateTime.now().plusMonths(2), "#001",
				new PersistirLocalmente());
		
		concurso.inscripcionNueva(participante.crearInscripcion());
		if (concurso.estaInscripto(participante)){
			correo = new CorreoElectronico ("nuestroCorreo@correo.com");
			correo.enviarNotificacion(participante.getCorreo(), "Inscripcion a concurso", ("Felicidades!! Estas inscripto al concurso" + concurso.getNombre()));
		}
	}

}
