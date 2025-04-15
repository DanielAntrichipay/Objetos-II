package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import persistencia.ConnectionManager;

public class CuentaDAOJDBC implements PersistirPrecioTotal {
	private static final String queryCreate = "INSERT INTO cuenta (fecha, precio) " + "VALUES (?, ?) ";

	@Override
	public void persistirCuenta(float costoTotal) {
		int cantidad = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(queryCreate);

			statement.setDate(1, Date.valueOf(LocalDateTime.now().toLocalDate()));
			statement.setFloat(2, costoTotal);

			cantidad = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.disconnect();
		}
	}

}