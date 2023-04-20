package exercicio14;
import java.util.Scanner;
public class ConversorDoTempoEmSegundos {
    public static int lerSegundosInseridosPeloUsuario(Scanner sc) {
        System.out.print("Digite o tempo em segundos para que este possa ser convertido em horas, minutos e segundos: ");
        return sc.nextInt();
    }

    public static int calcularHoras(int segundos) {
        return (segundos / 60) / 60;
    }

    public static int calcularMinutos(int segundos) {
        return ((segundos / 60) % 60); /*necessario para garantir que a conversao esteja correta em casos
        onde o numero inserido pelo usuario ainda haja segundos restantes apos a divisao por 60.*/

    }
    public static int calcularSegundosRestantesQueNaoFormamUmMinutoCompleto(int segundos) {
        return (segundos % 60);
    }

    public static void exibirConversao(int segundos) {
        int horas = calcularHoras(segundos);
        int minutos = calcularMinutos(segundos);
        int segundosRestantesQueNaoFormamUmMinutoCompleto = calcularSegundosRestantesQueNaoFormamUmMinutoCompleto(segundos);
        System.out.println(segundos + " segundos equivalem a: " + horas + "h," + minutos + "min e " + segundosRestantesQueNaoFormamUmMinutoCompleto + "seg.");
    }
}


