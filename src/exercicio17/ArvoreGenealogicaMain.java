package exercicio17;
public class ArvoreGenealogicaMain {
    public static void main(String[] args) {
        // familia
        Pessoa avoPaterno = new Pessoa("Luiz", 80, null, null);
        Pessoa avoPaterna = new Pessoa("Ana", 75, null, null);
        Pessoa avoMaterno = new Pessoa("José", 85, null, null);
        Pessoa avoMaterna = new Pessoa("Helena", 80, null, null);

        Pessoa pai = new Pessoa("João", 50, avoPaterno, avoPaterna);
        Pessoa mae = new Pessoa("Maria", 45, avoMaterno, avoMaterna);

        Pessoa filho = new Pessoa("Pedro", 20, pai, mae);

        System.out.println(filho.getNome() + " tem " + filho.getIdade() + " anos.");
        System.out.println(filho.getNome() + " é filho de " + filho.getPai().getNome() + " e " + filho.getMae().getNome() + ".");
        System.out.println(filho.getPai().getNome() + " é filho de " + filho.getPai().getPai().getNome() + " e " + filho.getPai().getMae().getNome() + ".");
        System.out.println(filho.getMae().getNome() + " é filha de " + filho.getMae().getPai().getNome() + " e " + filho.getMae().getMae().getNome() + ".");
    }
}
