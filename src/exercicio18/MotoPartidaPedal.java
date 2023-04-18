package exercicio18;

public class MotoPartidaPedal extends Moto{
    private boolean aceleradorPuxado;

    public MotoPartidaPedal(String marca, String modelo, int ano, String cor, boolean ligada, boolean aceleradorPuxado) {
        super(marca, modelo, ano, cor, ligada);
        this.aceleradorPuxado = aceleradorPuxado;
    }

    public void puxarAcelerador() {
        this.aceleradorPuxado = true;
        System.out.println("Acelerador puxado.");
    }

    public void soltarAcelerador() {
        this.aceleradorPuxado = false;
        System.out.println("Acelerador solto.");
    }

    @Override
    public void ligar() {
        if (this.aceleradorPuxado) {
            super.ligar();
        } else {
            System.out.println("O acelerador precisa estar puxado para que a moto possa ligar.");
        }
    }
}
