package Persistencia;

import org.example.Inscripcion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscripcionDAOJDBC implements PersistirInscriptos {
	private static final String queryCreate= "INSERT INTO inscripcion (fecha,  id_participante, id_concurso) "
			+ "VALUES ( ?, ?, ?) ";
	
	public void persistirUnInscripto(Inscripcion inscripcion) {
		int cantidad =0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn
					.prepareStatement(queryCreate);
			
			statement.setDate(1,  Date.valueOf(inscripcion.consultarFechaDeCreacion().toLocalDate()));
			statement.setString(2, inscripcion.obtenerIdUsuario());
			statement.setString(3, inscripcion.obtenerIdConcurso());
			
		cantidad= statement.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.disconnect();
		}
	}
}
