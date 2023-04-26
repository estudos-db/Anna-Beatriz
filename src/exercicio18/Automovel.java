package exercicio18;

public class Automovel {
    private final String marca;
    private final String modelo;
    private final int ano;
    private String cor;
    private int velocidadeAtual;
    public boolean ligado;

    public Automovel(String marca, String modelo, int ano, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.velocidadeAtual = 0;
        this.ligado = false;
    }
    public void ligar() {
        this.ligado = true;
    }
    public void acelerar(int velocidade) {
        if (this.ligado) {
            this.velocidadeAtual += velocidade;
        } else {
            System.out.println("O carro está desligado.");
        }
    }
    public void frear(int velocidade) {
        if (this.ligado) {
            this.velocidadeAtual -= velocidade;
        } else {
            System.out.println("O carro está desligado.");
        }
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }
    public String getCor(){
        return cor;
    }
    public int getAno(){
        return ano;
    }
}
