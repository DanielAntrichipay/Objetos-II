package Modelo;

public class Double {
    private java.lang.String name;
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int humidity;

    public Double(double feels_like, int humidity, java.lang.String name, double temp, double temp_max, double temp_min) {
        this.feels_like = feels_like;
        this.humidity = humidity;
        this.name = name;
        this.temp = temp;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
    }

    public double getFeelsLike() {
        return feels_like;
    }

    public int getHumidity() {
        return humidity;
    }

    public java.lang.String getName() {
        return name;
    }

    public double getTemp() {
        return temp;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }
}