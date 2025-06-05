package Modelo;

public class Medidor {
    private double temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemperatura() {
        //leo la temperatura del servicio web
        this.clima.temperatura().ifPresent(valor -> this.temperatura = valor.getTemp());
        return String.valueOf(this.temperatura);
    }
}
