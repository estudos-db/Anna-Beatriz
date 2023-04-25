package exercicio18;

public class CarroAutomaticoMain {
    public static void main(String[] args) {
        Carro carro = new Carro("Chevrolet", "Onix", 2012, "Branco");
        carro.ligar();
        carro.acelerar(80);
        carro.frear(10);

        CarroAutomatico carroAutomatico = new CarroAutomatico("Chevrolet", "Onix", 2021, "Cinza");
        carroAutomatico.acelerar(50);
        System.out.println("Para ligar o carro automático, é preciso pressionar o freio.");
    }
}

