package exercicioLutaEntreNinjas;

public interface Ninja {
        String getNome();
        int getChakra();
        int getVida();
        void consumirVida(int consumo);
        boolean temJutsu(String nomeJutsu);
        boolean desviar();
        String usarJutsu(Jutsu jutsu);
    }

