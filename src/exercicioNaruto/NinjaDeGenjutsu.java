package exercicioNaruto;

public class NinjaDeGenjutsu extends Personagem implements Ninja{
    public NinjaDeGenjutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra);
    }
    @Override
    public String usarJutsu() {
        return "O ninja " + this.getNome() + " está usando um jutsu de Genjutsu";
    }
    @Override
    public String desviar() {
        return "O ninja " + this.getNome() + " está desviando de um ataque usando sua habilidade em Genjutsu";
    }
}

