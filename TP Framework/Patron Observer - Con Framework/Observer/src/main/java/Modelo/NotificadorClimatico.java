package Modelo;

import java.util.ArrayList;
import java.util.List;

public class NotificadorClimatico {
    private List<ObservadorDelClima> observadoresDelClimas= new ArrayList<>();
    
    public void subscribirObservador (ObservadorDelClima observador){
        this.observadoresDelClimas.add(observador);
    }
    public void desuscribirObservador (ObservadorDelClima observador){
        this.observadoresDelClimas.remove(observador);
    }
    public void notify(double actualizacionDeTemperatura){
        for (ObservadorDelClima observador : this.observadoresDelClimas){
            observador.update(actualizacionDeTemperatura);
        }
    }
}
