package P4;

public class Main {
    public static void main(String[] args) {
        var pedido1 = new PorcionDePapas(3.0, new PorcionDeTomate(2.0,
                new ComboBasico("Hambueguesa y papas", 10.0)));
        var pedido2 = new PorcionDeCarne(5.0, new PorcionDeCarne(5.0, new PorcionDeQueso(2.0,
                new ComboBasico("Hambueguesa y papas", 10.0))))
    }
}
