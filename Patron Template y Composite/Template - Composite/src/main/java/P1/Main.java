package P1;

public class Main {
    public static void main(String[] args) {
        var director = new Director("Jose", 100000.0);

        var gerente1 = new Gerente("g1", 10000.0);
        var gerente2 = new Gerente("g2", 10000.0);

        var mandoMedio1 = new MandoMedio("m1", 1000.0);
        var mandoMedio2 = new MandoMedio("m2", 1000.0);

        var liderDeProyecto1 = new LiderDeProyecto("l1", 100.0);
        var liderDeProyecto2 = new LiderDeProyecto("l2", 100.0);
        var liderDeProyecto3 = new LiderDeProyecto("l3", 100.0);
        var liderDeProyecto4 = new LiderDeProyecto("l4", 100.0);

        var empleadoRegular1 = new EmpleadoRegular("n1", 10.0);
        var empleadoRegular2 = new EmpleadoRegular("n2", 10.0);
        var empleadoRegular3 = new EmpleadoRegular("n3", 10.0);
        var empleadoRegular4 = new EmpleadoRegular("n4", 10.0);
        var empleadoRegular5 = new EmpleadoRegular("n5", 10.0);
        var empleadoRegular6 = new EmpleadoRegular("n6", 10.0);
        var empleadoRegular7 = new EmpleadoRegular("n7", 10.0);
        var empleadoRegular8 = new EmpleadoRegular("n8", 10.0);

        director.asingnarGerente(gerente1);
        director.asingnarGerente(gerente2);

       gerente1.asingnarMandoMedio(mandoMedio1);
       gerente2.asingnarMandoMedio(mandoMedio2);

       mandoMedio1.asingnarLiderDeProyecto(liderDeProyecto1);
       mandoMedio1.asingnarLiderDeProyecto(liderDeProyecto2);
       mandoMedio2.asingnarLiderDeProyecto(liderDeProyecto3);
       mandoMedio2.asingnarLiderDeProyecto(liderDeProyecto4);

       liderDeProyecto1.asingnarEmpleadoRegular(empleadoRegular1);
       liderDeProyecto1.asingnarEmpleadoRegular(empleadoRegular2);
       liderDeProyecto2.asingnarEmpleadoRegular(empleadoRegular3);
       liderDeProyecto2.asingnarEmpleadoRegular(empleadoRegular4);
       liderDeProyecto3.asingnarEmpleadoRegular(empleadoRegular5);
       liderDeProyecto3.asingnarEmpleadoRegular(empleadoRegular6);
       liderDeProyecto4.asingnarEmpleadoRegular(empleadoRegular7);
       liderDeProyecto4.asingnarEmpleadoRegular(empleadoRegular8);

       System.out.println(director.calcularMontoTotalSalarial());
    }
}
