package outrosExercicios;

import java.util.Scanner;
public class DigitarNumeroAteSerONumeroDez {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //armazena numero digitado pelo usuario
        int numero = 0;

        while (numero != 10) {
            System.out.print("Digite um número: ");
            numero = input.nextInt();
        }

        System.out.println("Você digitou o número 10, logo, é o fim do programa.");
    }
}