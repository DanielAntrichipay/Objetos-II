package Main;

import Modelo.AlertaDeTemperatura;
import Modelo.ClimaOnline;
import Modelo.Medidor;
import Modelo.NotificadorClimatico;
import Persistencia.RegistroDeTemperaturas;
import Servicios.WeatherChannelService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        var notificadorClimatico = new NotificadorClimatico();
        ClimaOnline servicioCliamtico = new WeatherChannelService();
        var medidor = new Medidor(servicioCliamtico, notificadorClimatico);
        var registro = new RegistroDeTemperaturas();
        var alerta = new AlertaDeTemperatura();
    }
}