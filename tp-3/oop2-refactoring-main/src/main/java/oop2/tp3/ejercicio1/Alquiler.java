package oop2.tp3.ejercicio1;

public class Alquiler {
    private CopiaLibro copia;
    private int diasAlquilados;
    private int puntosDeAlquiler;

    public Alquiler(CopiaLibro copia, int diasAlquilados) {
        this.copia = copia;
        this.diasAlquilados = diasAlquilados;
        this.puntosDeAlquiler = 0;
    }

    public int diasAlquilados() {
        return this.diasAlquilados;
    }

    public double calcularMonto() {
        return this.copia.consultarLibro().clacularMonto(this.diasAlquilados);
    }

    public int calcularPuntosDeAlquiler (){
        this.puntosDeAlquiler ++;
        if (copia.consultarLibro().PoseePuntosExtrasDeAlquiler()){
            this.puntosDeAlquiler ++;
        }
        return this.puntosDeAlquiler;
    }
}
