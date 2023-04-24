package exercicio18;

public class GuinchoMain {
    public static void main(String[] args) {
        Guincho guincho = new Guincho();

        Carro carro = new Carro("Chevrolet", "Onix", 2012, "Branco");
        Moto moto = new Moto("Kawasaki", "Ninja ZX-10R", 2023, "Verde", true);

        guincho.carregar(carro);
        guincho.carregar(moto);
    }
}
