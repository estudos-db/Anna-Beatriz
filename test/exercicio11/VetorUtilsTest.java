package exercicio11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class VetorUtilsTest {

    @Test
    public void testCriarVetor() {
        int tamanho = 100;
        int[] vetor = BubbleSort.VetorUtils.criarVetor(tamanho);

        // Verificar se o vetor foi criado corretamente
        assertEquals(tamanho, vetor.length);

        // Verificar se todos os elementos do vetor estão entre 0 e 999
        for (int indiceAtual = 0; indiceAtual < tamanho; indiceAtual++) {
            assertTrue(vetor[indiceAtual] >= 0 && vetor[indiceAtual] <= 999);
        }

        // Verificar se o vetor criado é diferente de um vetor criado anteriormente
        int[] outroVetor = BubbleSort.VetorUtils.criarVetor(tamanho);
        boolean saoIguais = true;
        for (int indiceAtual = 0; indiceAtual < tamanho; indiceAtual++) {
            if (vetor[indiceAtual] != outroVetor[indiceAtual]) {
                saoIguais = false;
                break;
            }
        }
        assertFalse(saoIguais);
    }
}
