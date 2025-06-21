package Servicios;
import Modelo.ClimaOnline;
import Modelo.Double;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class WeatherChannelService implements ClimaOnline {

    @Override
    public Optional<Double> temperatura() {
        java.lang.Double temp;
        java.lang.String apiKey = "acb4891961c6ece1543abd7933e9baad";
        java.lang.String urlString = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&APPID=" + apiKey;
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
                java.lang.String linea;
                while ((linea = lector.readLine()) != null) {
                    respuesta.append(linea);
                }

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(respuesta.toString(), JsonObject.class);

                JsonObject main = jsonObject.getAsJsonObject("main");
                // Creo objeto Clima y asigno valores
                return Optional.of(main.get("temp").getAsDouble());
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el clima: " + e.getMessage());
            return Optional.empty();
        }
    }
}
