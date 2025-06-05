package Main;

import Modelo.AlertaDeTemperatura;
import Modelo.NotificadorClimatico;
import Persistencia.RegistroDeTemperaturas;
import Servicios.WeatherChannelService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        var notificadorClimatico = new NotificadorClimatico();
        var servicioCliamtico = new WeatherChannelService(notificadorClimatico);
        var registro = new RegistroDeTemperaturas();
        var alerta = new AlertaDeTemperatura();

        notificadorClimatico.subscribirObservador(registro);
        notificadorClimatico.subscribirObservador(alerta);
        servicioCliamtico.temperatura();
    }
}