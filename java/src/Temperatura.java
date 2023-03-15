import java.text.DecimalFormat;
import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {
        //variáveis
        double c,f; //Permite a entrada de dados via teclado quando usamos o console
        //Objetos
        Scanner teclado = new Scanner(System.in);

        DecimalFormat formatador = new DecimalFormat("#0.0"); //Formata o resultado em apenas uma casa decimal

        System.out.println("Conversão de temperatura");
        System.out.print("Digite a temperatura em fahreinheit para conversão:");
        //Detectar o que foi digitado no teclado e armazenar na variável f
        f = teclado.nextDouble();
        //processamento
        c = (5 * (f - 32)) / 9;
        //exibir resultado
        System.out.println("A temperatura em celsius é:" + formatador.format(c) + "ºC");

        teclado.close(); // Não permite mais entrada de dados.
    }
}