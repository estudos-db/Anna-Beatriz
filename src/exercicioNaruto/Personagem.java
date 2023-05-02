package exercicioNaruto;

public class Personagem {
    private String nome;
    private final int idade;
    private final String aldeia;
    private int chakra;
    private String[] jutsus;

    public Personagem(String nome, int idade, String aldeia, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.setChakra(chakra);
        this.jutsus = new String[1];
    }

    public String aprenderJutsu(String jutsu) {
        for (String j : this.jutsus) {
            if (j != null && j.equals(jutsu)) {
                return "O ninja " + this.nome + " já aprendeu o jutsu " + jutsu + ".";
            }
        }
        int contadorDeJutsus = 0;
        for (int i = 0; i < this.jutsus.length; i++) {
            if (this.jutsus[i] == null) {
                this.jutsus[i] = jutsu;
                return "O ninja " + this.nome + " aprendeu o jutsu " + jutsu + ".";
            }
            contadorDeJutsus++;
        }
        if (contadorDeJutsus == 3) {
            return "O ninja " + this.nome + " já aprendeu o máximo de jutsus permitido.";
        }
        return "Erro inesperado ao tentar aprender jutsu.";
    }

    public String aumentarChakra(int valor) {
        if(valor <= 0) {
            return "O aumento do chakra não pode ser nulo ou negativo.";
        }
        this.chakra += valor;
        return "O total de chakra do ninja " + this.nome + " agora é " + this.chakra + ".";
    }
    public void setChakra(int chakra) {
        if(chakra >= 0 && chakra <= 50) {
            this.chakra = chakra;
        } else {
            throw new IllegalArgumentException("Um ninja iniciante não consegue ter um chakra superior a 50.");
        }
    }

    public int getChakra() {
        return chakra;
    }

    public String exibirInfo() {
        StringBuilder jutsusString = new StringBuilder("[");
        for(int i = 0; i < this.jutsus.length; i++) {
            if(this.jutsus[i] != null) {
                jutsusString.append(this.jutsus[i]);
                if(i != this.jutsus.length - 1) {
                    jutsusString.append(", ");
                }
            }
        }
        jutsusString.append("]");

        return "Personagem:\nNome: " + this.nome + "\nIdade: " + this.idade + "\nAldeia: " + this.aldeia
                + "\nChakra total: " + this.chakra + "\nLista de jutsus: " + jutsusString;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getAldeia() {
        return aldeia;
    }
}