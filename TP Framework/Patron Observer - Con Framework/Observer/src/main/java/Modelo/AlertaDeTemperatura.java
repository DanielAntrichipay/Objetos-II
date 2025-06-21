package Modelo;

public class AlertaDeTemperatura implements ObservadorDelClima{

    public static final String HACE_FRIO = "Hace frio, se encenderá la caldera";
    public static final String HACE_CALOR = "Hace calor, se encenderá el aire acondicionado";

    @Override
    public void update(double temperaturaActual) {
        double temperaturaMinima = 12;
        double temperaturaMaxima = 17;

        if (temperaturaActual < temperaturaMinima ){
            System.out.println(HACE_FRIO);
        }
        else if (temperaturaActual > temperaturaMaxima ){
            System.out.println(HACE_CALOR);
        }
    }
}
