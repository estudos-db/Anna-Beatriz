package exercicio12;

import java.util.*;

public class MainVetorUtils {

    public static void main(String[] args) {
        int[] vetor1 = VetorUtils.criarVetor(50);

        int[] vetor2 = VetorUtils.criarVetor(50);

        System.out.println("Vetor 1 antes da ordenação: " + Arrays.toString(vetor1));
        BubbleSort.bubbleSort(vetor1);
        System.out.println("Vetor 1 após a ordenação: " + Arrays.toString(vetor1));

        System.out.println("Vetor 2 antes da ordenação: " + Arrays.toString(vetor2));
        BubbleSort.bubbleSort(vetor2);
        System.out.println("Vetor 2 após a ordenação: " + Arrays.toString(vetor2));

        int[] novoVetor = VetorUtils.combinarVetoresOrdenados(vetor1, vetor2);

        System.out.println("Novo vetor após a combinação e ordenação: " + Arrays.toString(novoVetor));
    }
}

