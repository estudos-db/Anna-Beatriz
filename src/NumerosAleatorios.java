import java.util.Random;

public class NumerosAleatorios {
    public static void main(String[] args) {
        Random random = new Random();
        int min = 100;
        int max = 0;


        //repete 10 vezes pra gerar 10 números aleatórios
        for (int i = 0; i < 10; i++) {

        //gera numero aleatorio e armazena na variavel
            int randomNumber = random.nextInt(101);
            System.out.print(randomNumber + " ");

        //verifica se o numero é menor que a variavel min. se for, o valor da variavel min é atualizado
            if (randomNumber < min) {
                min = randomNumber;
            }

        //verifica se o numero é maior que a variavel max. se for, o valor da variavel max é atualizado
            if (randomNumber > max) {
                max = randomNumber;
            }
        }

        System.out.println("O menor número da lista é " + min + ". O maior número é " + max + ".");
    }
}