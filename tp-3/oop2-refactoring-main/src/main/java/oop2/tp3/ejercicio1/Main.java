package oop2.tp3.ejercicio1;

public class Main {
    public static void main(String args[]) {

        Object[] resultado = new Object[2];
        Libro elTunel = new LibroRegular("El Túnel", 23);
        Libro antesDelFin = new LibroRegular("Antes del Fin", 23);
        
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
        
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        
        Cliente yo = new Cliente("Javier");
        
        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);
        
        resultado[0]= yo.calcularDeuda();
        resultado[1]= yo.calcularPuntosFrecuentes();
        System.out.println(resultado[0]);
        System.out.println(resultado[1]);
    }
}