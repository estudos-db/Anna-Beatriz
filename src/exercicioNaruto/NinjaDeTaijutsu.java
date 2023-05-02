package exercicioNaruto;

//Ninjas de Taijutsu nao utilizam chakra, sao tecnicas corporais
public class NinjaDeTaijutsu extends Personagem implements Ninja {
    public NinjaDeTaijutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, 0);
        setChakra(chakra);
    }
    @Override
    public String usarJutsu() {
        return "O ninja " + getNome() + " está usando um golpe de Taijutsu";
    }

    @Override
    public String desviar() {
        return "O ninja " + getNome() + " está desviando de um ataque usando sua habilidade em Taijutsu";
    }

    @Override
    public String aumentarChakra(int valor) {
        return "Um ninja de Taijutsu não pode aumentar seu chakra";
    }

    public void setChakra(int chakra) {
        if (chakra > 0 && chakra <= 10) {
            this.setChakra(chakra);
        } else {
            throw new IllegalArgumentException("Um ninja iniciante não pode ter essa quantidade de chakra");
        }
    }
}
