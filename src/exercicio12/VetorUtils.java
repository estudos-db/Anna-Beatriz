package src.exercicio12;
import java.util.Random;

public class VetorUtils {
    public static int[] criarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int indiceAtual = 0; indiceAtual < tamanho; indiceAtual++) {
            vetor[indiceAtual] = random.nextInt(1000);
        }

        return vetor;
    }

    public static int[] combinarVetoresOrdenados(int[] vetor1, int[] vetor2) {
        int[] novoVetor = new int[vetor1.length + vetor2.length];

        int indiceAtualDoNovoVetor = 0, indiceAtualDoVetor1 = 0, indiceAtualDoVetor2 = 0;
        while (indiceAtualDoVetor1 < vetor1.length && indiceAtualDoVetor2 < vetor2.length) {
            if (vetor1[indiceAtualDoVetor1] < vetor2[indiceAtualDoVetor2]) {
                novoVetor[indiceAtualDoNovoVetor++] = vetor1[indiceAtualDoVetor1++];
            } else {
                novoVetor[indiceAtualDoNovoVetor++] = vetor2[indiceAtualDoVetor2++];
            }
        }

        while (indiceAtualDoVetor1 < vetor1.length) {
            novoVetor[indiceAtualDoNovoVetor++] = vetor1[indiceAtualDoVetor1++];
        }

        while (indiceAtualDoVetor2 < vetor2.length) {
            novoVetor[indiceAtualDoNovoVetor++] = vetor2[indiceAtualDoVetor2++];
        }

        return novoVetor;
    }
}
