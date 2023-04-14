package src.exercicio12;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] vetor1 = VetorUtils.criarVetor(50);
        int[] vetor2 = VetorUtils.criarVetor(50);
        System.out.println("Vetor 1 antes da ordenação: " + Arrays.toString(vetor1));
        System.out.println("Vetor 2 antes da ordenação: " + Arrays.toString(vetor2));

        bubbleSort(vetor1);
        bubbleSort(vetor2);

        System.out.println("Vetor 1 após a ordenação: " + Arrays.toString(vetor1));
        System.out.println("Vetor 2 após a ordenação: " + Arrays.toString(vetor2));

        int[] novoVetor = VetorUtils.combinarVetoresOrdenados(vetor1, vetor2);
        bubbleSort(novoVetor);

        System.out.println("Novo vetor ordenado: " + Arrays.toString(novoVetor));
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
}