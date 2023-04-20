package src.exercicio9;

import src.exercicio9.GeradorFibonacci;
import java.util.Scanner;

public class ContarFibonacciAteCertoNumero {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um número inteiro que não seja negativo: ");
        int numeroDoUsuario = input.nextInt();

        System.out.println(GeradorFibonacci.sequenciaFibonacci(numeroDoUsuario));
    }
}

