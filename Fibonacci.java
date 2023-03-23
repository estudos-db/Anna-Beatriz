import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro que não seja negativo: ");
        int numero = input.nextInt();

        //primeiros valores da sequencia fibonacci, variavel c armazena soma
        int a = 0, b = 1, c;

        System.out.print(a + ", " + b);

        //a cada iteraçao, variavel c é atualizada
        for (int i = 1; i < numero; i++) {
            c = a + b;
            System.out.print(", " + c);

        //atualiza os valores anteriores para a proxima iteraçao
            a = b;
            b = c;
        }
        System.out.println();
    }
}