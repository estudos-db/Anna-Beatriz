package exercicio18;

public class Carro extends Automovel {
    public Carro(String marca, String modelo, int ano, String cor) {
        super(marca, modelo, ano, cor);
    }
    public boolean isLigado() {
        return ligado;
    }
}
