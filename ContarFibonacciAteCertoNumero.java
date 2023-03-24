import java.util.Scanner;
public class ContarFibonacciAteCertoNumero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um número inteiro que não seja negativo: ");

        int numero = input.nextInt();

        //primeiros valores da sequencia fibonacci, variavel c armazena soma
        int a = 0, b = 1, c;

        //loop que roda ate que o valor de "a" seja maior que o numero inserido pelo usuario
        while (a <= numero) {
            System.out.print(a + ",");
            c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }
}
