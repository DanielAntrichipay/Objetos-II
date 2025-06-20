package Ejercicio1.Modelo;

import Ejercicio1.Persistencia.ParticipanteDAOJDBC;

public class Api implements Iapi{
    private ParticipanteDAO participanteDAO;

    public Api() {
        this.participanteDAO = new ParticipanteDAOJDBC();
    }

    @Override
    public void caragarParticipante(String nombre, String telefono, String region) {
        participanteDAO.create(nombre, telefono, region);
    }
}
