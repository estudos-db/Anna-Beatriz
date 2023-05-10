package exercicioLutaEntreNinjas;

import java.util.HashMap;
import java.util.Map;

public class Personagem {
    private String nome;
    private Map<String, Jutsu> jutsus;
    private int chakra = 100;
    private int vida = 100;
    public Personagem(String nome) {
        this.nome = nome;
        this.jutsus = new HashMap<>();
    }
    public String aprenderJutsu(String nomeDoJutsu, Jutsu jutsu) {
        if(!jutsus.containsKey(nomeDoJutsu)) {
            jutsus.put(nomeDoJutsu, jutsu);
            return "O ninja " + this.nome + " acabou de aprender o jutsu " + nomeDoJutsu + "!";
        } else {
            return "O ninja " + this.nome +  " já aprendeu esse jutsu.";
        }
    }
    public boolean temJutsu(String nomeJutsu) {
        return jutsus.containsKey(nomeJutsu);
    }
    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }
    public String getNome() {
        return nome;
    }
    public int getChakra() {
        return chakra;
    }
    public void setChakra(int chakra) {
        this.chakra = chakra;
    }
    public int getVida() {
        return vida;
    }
    public void consumirVida(int consumo) {
        this.vida -= consumo;
    }
    public void consumirChakra(int consumo) {
        this.chakra -= consumo;
        if (this.chakra < 0) {
            this.chakra = 0;
        }
    }
    public String usarJutsu(Jutsu jutsu) {
        if(this.getChakra() < jutsu.getConsumoDeChakra()) {
            this.setChakra(0);
            return "O ninja não pode usar esse jutsu, falta chakra.";
        }
        consumirChakra(jutsu.getConsumoDeChakra());
        return "O ninja " + this.nome + " está atacando usando o " + jutsu.getNome();
    }
    public boolean desviar() {
        if(this.getChakra() <= 5) {
            System.out.println("O ninja não pode desviar por falta de chakra");
            return false;
        }
        consumirChakra(5);
        double conseguirDesviar = Math.floor(Math.random() * 2);
        return conseguirDesviar == 1;
    }
}
