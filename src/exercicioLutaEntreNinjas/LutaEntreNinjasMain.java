package exercicioLutaEntreNinjas;

public class LutaEntreNinjasMain {
    public static void main(String[] args) {
        NinjaDeNinjutsu kakashi = new NinjaDeNinjutsu("Kakashi");
        NinjaDeTaijutsu rockLee = new NinjaDeTaijutsu("Rock Lee");

        Jutsu chidori = new Jutsu("Chidori", 10, 5);
        Jutsu chute = new Jutsu("Chute", 5, 0);

        kakashi.aprenderJutsu(chidori.getNome(), chidori);
        rockLee.aprenderJutsu(chute.getNome(), chute);

        Luta luta = new Luta(kakashi, rockLee);

        System.out.println(luta.ordenarNinjas());

        System.out.println(luta.luta(kakashi, chidori, rockLee, false));
        System.out.println(luta.luta(rockLee, chute, kakashi, true));
    }
}
