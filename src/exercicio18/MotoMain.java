package exercicio18;

public class MotoMain {
    public static void main(String[] args) {
        MotoPartidaPedal moto = new MotoPartidaPedal("Kawasaki", "Ninja ZX-10R", 2023, "Verde", false, false);
        moto.ligar(); //  "O acelerador precisa estar puxado para que a moto possa ligar."
        moto.puxarAcelerador(); // acelerador puxado
        moto.ligar(); // moto liga
        moto.acelerar(50);
        moto.soltarAcelerador();
        moto.frear(10);
    }
}
