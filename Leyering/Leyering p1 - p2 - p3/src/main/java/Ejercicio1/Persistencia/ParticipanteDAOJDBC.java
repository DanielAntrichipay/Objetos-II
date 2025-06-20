package Ejercicio1.Persistencia;

import Ejercicio1.Modelo.ParticipanteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ParticipanteDAOJDBC implements ParticipanteDAO {
    public static final String queryInsertParticipante = "insert into participantes(nombre, telefono, region) values(?,?,?)";
    private Connection dbConn;
    String url = "jdbc:derby://localhost:1527/participantes";
    String user = "app";
    String password = "app";

    @Override
    public void create(String nombre, String telefono, String region){
        try {
            this.dbConn = DriverManager.getConnection(url, user, password);
            try (PreparedStatement st = dbConn.prepareStatement(queryInsertParticipante)) {
                st.setString(1, nombre);
                st.setString(2, telefono);
                st.setString(3, region);
                st.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
