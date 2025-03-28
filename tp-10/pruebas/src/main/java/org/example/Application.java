package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Application {
    public static void main(String[] args) throws Exception {
        // Configura el servidor Jetty
        Server server = new Server(8080);

        // Configura el contexto de la aplicación web
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar("src/main/webapp"); // Carpeta donde se generará el WAR
        server.setHandler(context);

        // Inicia el servidor
        server.start();
        server.join();
    }
}
