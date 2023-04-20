package exercicio14;

import java.util.Scanner;

import static exercicio14.ConversorDoTempoEmSegundos.exibirConversao;
import static exercicio14.ConversorDoTempoEmSegundos.lerSegundosInseridosPeloUsuario;
public class LeitorDoUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int segundos = lerSegundosInseridosPeloUsuario(sc);
        exibirConversao(segundos);
        sc.close();
    }
}
