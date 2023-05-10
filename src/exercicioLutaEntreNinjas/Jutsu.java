package exercicioLutaEntreNinjas;

public class Jutsu {
    private String nome;
    private int dano;
    private int consumoDeChakra;
    public Jutsu(String nome, int dano, int consumoDeChakra) {
        this.nome = nome;
        this.setDano(dano);
        this.setConsumoDeChakra(consumoDeChakra);
    }
    public void setDano(int dano) {
        if(dano < 0)
            throw new IllegalArgumentException("O dano não pode ser negativo.");
        this.dano = dano;
    }
    public void setConsumoDeChakra(int consumoDeChakra) {
        if(consumoDeChakra < 0)
            throw new IllegalArgumentException("O consumo de chakra não pode ser negativo.");
        this.consumoDeChakra = consumoDeChakra;
    }
    public String getNome() {
        return nome;
    }
    public int getDano() {
        return dano;
    }
    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }
}
