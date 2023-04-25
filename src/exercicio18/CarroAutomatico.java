package exercicio18;

public class CarroAutomatico extends Carro{
    private boolean freioPressionado;

    public CarroAutomatico(String marca, String modelo, int ano, String cor) {
        super(marca, modelo, ano, cor);
        this.freioPressionado = false;
    }
    @Override
    public void ligar() {
        if (this.freioPressionado) {
            super.ligar();
        } else {
            System.out.println("Para ligar o carro automático, é preciso pressionar o freio.");
        }
    }
    public void setFreioPressionado(boolean freioPressionado) {
        this.freioPressionado = freioPressionado;
    }
    @Override
    public boolean isLigado() {
        if (this.freioPressionado) {
            return super.isLigado();
        } else {
            return false;
        }
    }
}
