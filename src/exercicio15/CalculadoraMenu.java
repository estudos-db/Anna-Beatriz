package exercicio15;

import java.util.Scanner;
import static exercicio15.CalculadoraOperacoes.*;

public class CalculadoraMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char opcao;

        while (true) {
            exibirMenu();
            opcao = scanner.next().charAt(0);

            if (opcao == 'F') {
                System.out.println("Ok! Saindo da calculadora...");
                break;
            } else if (opcao == '0') {
                System.out.println("Essa opção é inválida. Por favor, tente novamente.");
            } else if (opcao >= 'A' && opcao <= 'E') {
                System.out.print("Digite o primeiro número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Digite o segundo número: ");
                double num2 = scanner.nextDouble();

                double resultado = 0;
                switch (opcao) {
                    case 'A' -> resultado = somar(num1, num2);
                    case 'B' -> resultado = subtrair(num1, num2);
                    case 'C' -> resultado = multiplicar(num1, num2);
                    case 'D' -> resultado = dividir(num1, num2);
                    case 'E' -> resultado = potencia(num1, num2);
                }
                exibirResultado(opcao, resultado);
                System.out.println("Operação escolhida encerrada.");
            } else {
                System.out.println("Talvez você tenha acidentalmente digitado sua opção do menu em letra minúscula." +
                        " Tente novamente, qualquer outro caractere diferente das opções do menu é uma opção inválida.");
            }

        }
        scanner.close();
    }
    public static void exibirMenu() {
        System.out.println("Escolha a operação desejada:");
        System.out.println("A - Para soma");
        System.out.println("B - Para subtração");
        System.out.println("C - Para multiplicação");
        System.out.println("D - Para divisão");
        System.out.println("E - Para potenciação");
        System.out.println("F - Para finalizar o programa.");
    }
    public static void exibirResultado(char operacao, double resultado) {
        System.out.printf("O resultado da sua operação %c é: %.2f%n", operacao, resultado);
    }
}
