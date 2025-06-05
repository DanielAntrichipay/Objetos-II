package Modelo;

public class AlertaDeTemperatura implements ObservadorDelClima{

    public static final String HACE_FRIO = "Hace frio, se encenderá la caldera";
    public static final String HACE_CALOR = "Hace calor, se encenderá el aire acondicionado";

    @Override
    public void update(String temperaturaActual) {
        double temperaturaMinima = 12;
        double temperaturaMaxima = 17;

        if (Double.parseDouble(temperaturaActual) < temperaturaMinima ){
            System.out.println(HACE_FRIO);
        }
        else if (Double.parseDouble(temperaturaActual) > temperaturaMaxima ){
            System.out.println(HACE_CALOR);
        }
    }
}
