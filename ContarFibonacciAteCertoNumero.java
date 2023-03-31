package testjava;
import java.util.Scanner;

public class ContarFibonacciAteCertoNumero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um número inteiro que não seja negativo: ");
        int numeroDoUsuario = input.nextInt();
        System.out.println(sequenciaFibonacci(numeroDoUsuario));

        public static String sequenciaFibonacci(int numeroDoUsuario) {

        //primeiros valores (termos) da sequencia fibonacci e o próximo termo da sequência, após a soma dos dois números anteriores
        int primeiroTermo = 0, segundoTermo = 1, termoPosSoma;

        //loop que roda ate que o valor do primeiro termo seja maior que o numero inserido pelo usuario
        
        String resultado = "";        
        while (primeiroTermo <= numeroDoUsuario) {
            System.out.print(primeiroTermo + ",");
            termoPosSoma = primeiroTermo + segundoTermo;
            primeiroTermo = segundoTermo;
            segundoTermo = termoPosSoma;
        }

         return resultado;
    }
}
