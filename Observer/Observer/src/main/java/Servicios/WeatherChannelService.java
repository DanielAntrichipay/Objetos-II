package Servicios;

import Modelo.Clima;
import Modelo.ClimaOnline;
import Modelo.NotificadorClimatico;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class WeatherChannelService implements ClimaOnline {
    private NotificadorClimatico notificadorClimatico;

    public WeatherChannelService(NotificadorClimatico notificadorClimatico) {
        this.notificadorClimatico = notificadorClimatico;
    }

    @Override
    public Optional<Clima> temperatura() {
//        int temp = new Random().nextInt(100);
        String apiKey = "acb4891961c6ece1543abd7933e9baad";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&APPID=" + apiKey;
        Clima clima;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            // Verificar código de respuesta
            if (conexion.getResponseCode() != 200) {
                throw new RuntimeException("Error HTTP: " + conexion.getResponseCode());
            }

            try (BufferedReader lector = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()))) {

                StringBuilder respuesta = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    respuesta.append(linea);
                }

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(respuesta.toString(), JsonObject.class);

                JsonObject main = jsonObject.getAsJsonObject("main");
                // Creo objeto Clima y asigno valores
                clima = new Clima(
                        main.get("temp").getAsDouble(),
                        main.get("humidity").getAsInt(),
                        jsonObject.get("name").getAsString(),
                        main.get("temp").getAsDouble(),
                        main.get("temp_max").getAsDouble(),
                        main.get("temp_min").getAsDouble()
                );
                notificadorClimatico.notify(String.valueOf(clima.getTemp()));
                return Optional.of(clima);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el clima: " + e.getMessage());
            return Optional.empty();
        }
    }
}
