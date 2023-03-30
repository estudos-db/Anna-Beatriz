import java.util.Scanner;
public class ContarFibonacciAteCertoNumero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um número inteiro que não seja negativo: ");

        int numeroDoUsuario = input.nextInt();

        //primeiros valores (termos) da sequencia fibonacci e o próximo termo da sequência, após a soma dos dois números anteriores
        int primeiroTermo = 0, segundoTermo = 1, termoPosSoma;

        //loop que roda ate que o valor do primeiro termo seja maior que o numero inserido pelo usuario
        while (primeiroTermo <= numeroDoUsuario) {
            System.out.print(primeiroTermo + ",");
            termoPosSoma = primeiroTermo + segundoTermo;
            primeiroTermo = segundoTermo;
            segundoTermo = termoPosSoma;
        }

        System.out.println();
    }
}
