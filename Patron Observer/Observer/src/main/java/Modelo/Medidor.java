package Modelo;

import Servicios.WeatherChannelService;

public class Medidor { ;
    private NotificadorClimatico notificadorClimatico;
    private ClimaOnline clima;
    private double temperatura;

    public Medidor(ClimaOnline servicioClimatico, NotificadorClimatico notificadorClimatico) {
        this.clima = servicioClimatico;
        this.notificadorClimatico = notificadorClimatico;
    }

    public double leerTemperatura() {
        //leo la temperatura del servicio web
        this.clima.temperatura());
        this.notificadorClimatico.notify(temperatura);
        return temperatura;
    }
}
