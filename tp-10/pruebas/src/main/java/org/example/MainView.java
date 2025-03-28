package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("") // Define la ruta de la vista (http://localhost:8080/)
public class MainView extends VerticalLayout {

    public MainView() {
        // Configura el layout
        setAlignItems(Alignment.CENTER); // Centra los componentes horizontalmente
        setJustifyContentMode(JustifyContentMode.CENTER); // Centra los componentes verticalmente
        setSizeFull(); // Ocupa toda la pantalla

        // Título de la página
        add(new com.vaadin.flow.component.html.H1("Bienvenido a Mi Aplicación Vaadin"));

        // Campo de texto para el nombre
        TextField nameField = new TextField("Ingresa tu nombre");
        nameField.setPlaceholder("Ej: Juan Pérez");

        // Botón para saludar
        Button greetButton = new Button("Saludar");
        greetButton.addClickListener(e -> {
            String name = nameField.getValue();
            if (name == null || name.trim().isEmpty()) {
                Notification.show("Por favor, ingresa tu nombre.");
            } else {
                Notification.show("¡Hola, " + name + "!");
            }
        });

        // Agrega los componentes al layout
        add(nameField, greetButton);
    }
}
