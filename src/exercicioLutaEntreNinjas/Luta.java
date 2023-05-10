package exercicioLutaEntreNinjas;

public class Luta {
    private Ninja primeiroNinja;
    private Ninja segundoNinja;
    public Luta(Ninja primeiroNinja, Ninja segundoNinja) {
        this.primeiroNinja = primeiroNinja;
        this.segundoNinja = segundoNinja;
    }
    public String ordenarNinjas() {
        double resultado = Math.floor(Math.random() * 2);
        Ninja ninjaQueComecaLuta;
        if (resultado == 1)
            ninjaQueComecaLuta = primeiroNinja;
        else
            ninjaQueComecaLuta = segundoNinja;
        return "O primeiro movimento é do ninja " + ninjaQueComecaLuta.getNome() + "!";
    }
    public String luta(Ninja atacante, Jutsu jutsu, Ninja defensor, boolean tentouDesviar) {
        try {
            verificarSeNinjaTemJutsu(atacante, jutsu);
        } catch (Exception e) {
            return e.getMessage();
        }
        atacante.usarJutsu(jutsu);
        StringBuilder sb = new StringBuilder("O ninja ").append(atacante.getNome()).append(" usou ").append(jutsu.getNome()).append(" para atacar!");

        if (tentouDesviar) {
            if (defensor.desviar()) {
                sb.append("\nO ninja ").append(defensor.getNome()).append(" desviou!");
                verificarStatus(sb, atacante);
                verificarStatus(sb, defensor);
                return sb.toString();
            }
            sb.append("\nO ninja ").append(defensor.getNome()).append(" não conseguiu desviar!");
        }
        defensor.consumirVida(jutsu.getDano());
        sb.append("\nO ninja ").append(defensor.getNome()).append(" levou ").append(jutsu.getDano()).append(" de dano!");

        verificarStatus(sb, atacante);
        verificarStatus(sb, defensor);
        return sb.toString();
    }
    public void verificarStatus(StringBuilder msg, Ninja ninja) {
        if (ninja.getChakra() == 0) {
            msg.append("\nO ninja ")
                    .append(ninja.getNome())
                    .append(" tem chakra insuficiente para continuar a luta.");
        }
    }
    public void verificarSeNinjaTemJutsu(Ninja atacante, Jutsu jutsu) {
        if(!atacante.temJutsu(jutsu.getNome())) {
            String msg = "O ninja " + atacante.getNome() + " não possui o jutsu " + jutsu.getNome() + ".";
            throw new IllegalArgumentException(msg);
        }
    }
    public void verificarSeNinjaEstaVivo(Ninja ninja) {
        if(ninja.getVida() == 0) {
            String msg = "O ninja " + ninja.getNome() + " não possui mais vida para atacar.";
            throw new IllegalArgumentException(msg);
        }
    }
    public Ninja getSegundoNinja() {
        return segundoNinja;
    }
    public Ninja getPrimeiroNinja() {
        return primeiroNinja;
    }
}
