package Modelo;

import Servicios.WeatherChannelService;
import antrichipay.framework.Accion;

public class Medidor implements Accion { ;
    private NotificadorClimatico notificadorClimatico;
    private ClimaOnline clima;
    private double temperatura;

    public Medidor(ClimaOnline servicioClimatico, NotificadorClimatico notificadorClimatico) {
        this.clima = servicioClimatico;
        this.notificadorClimatico = notificadorClimatico;
    }

    public double leerTemperatura() {
        //leo la temperatura del servicio web
        this.clima.temperatura();
        this.notificadorClimatico.notify(temperatura);
        return temperatura;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando Medidor");
    }

    @Override
    public String nombreItemMenu() {
        return "Medidor";
    }

    @Override
    public String descripcionItemMenu() {
        return "Mide la temperatura a través de ";
    }
}
