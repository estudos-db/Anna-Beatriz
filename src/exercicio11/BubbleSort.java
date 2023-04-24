package exercicio11;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] vetor = VetorUtils.criarVetor(100);
        System.out.println("Vetor antes da ordenação: " + Arrays.toString(vetor));

        bubbleSort(vetor);

        System.out.println("Vetor após a ordenação: " + Arrays.toString(vetor));
    }

    public static void bubbleSort(int[] vetor) {
        int tamanho = vetor.length;
        int valorTemporario = 0;

        for (int indiceAtual = 0; indiceAtual < tamanho; indiceAtual++) {
            for (int indiceComparado = 1; indiceComparado < (tamanho - indiceAtual); indiceComparado++) {
                if (vetor[indiceComparado - 1] > vetor[indiceComparado]) {
                    valorTemporario = vetor[indiceComparado - 1];
                    vetor[indiceComparado- 1] = vetor[indiceComparado];
                    vetor[indiceComparado] = valorTemporario;
                }
            }
        }
    }

    class VetorUtils {
        public static int[] criarVetor(int tamanho) {
            int[] vetor = new int[tamanho];
            Random random = new Random();

            for (int indiceAtual = 0; indiceAtual < tamanho; indiceAtual++) {
                vetor[indiceAtual] = random.nextInt(1000);
            }

            return vetor;
        }
    }
}