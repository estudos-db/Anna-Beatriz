package test.exercicio12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.exercicio12.VetorUtils;

public class VetorUtilsTest {

    @Test
  @DisplayName("Deve criar um vetor de 50 posições com valores aleatórios")

    public void testCriarVetor() {
        int[] vetor = VetorUtils.criarVetor(50);
        Assertions.assertEquals(50, vetor.length);
    }

    @Test
    @DisplayName("Deve combinar dois vetores ordenados em um novo vetor, também ordenado")
    public void testCombinarVetoresOrdenados() {
        int[] vetor1 = {1, 3, 5, 7, 9};
        int[] vetor2 = {2, 4, 6, 8, 10};

        int[] vetorOrdenadoEsperado = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] novoVetor = VetorUtils.combinarVetoresOrdenados(vetor1, vetor2);

        Assertions.assertArrayEquals(vetorOrdenadoEsperado, novoVetor);
    }
}