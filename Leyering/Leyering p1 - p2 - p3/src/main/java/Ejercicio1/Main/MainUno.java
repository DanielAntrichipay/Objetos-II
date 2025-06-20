package Ejercicio1.Main;

import Ejercicio1.UI.AgregarParticipante;

import java.awt.EventQueue;
import java.sql.SQLException;

public class MainUno {
    public static void main(String[] args) throws SQLException{
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}