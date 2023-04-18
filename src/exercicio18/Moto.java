package exercicio18;

public class Moto extends Automovel {
    private final boolean ligada;
    public Moto(String marca, String modelo, int ano, String cor, boolean ligada) {
        super(marca, modelo, ano, cor);
        this.ligada = ligada;
    }
}
