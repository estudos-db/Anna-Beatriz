package exercicioExcecaoCodeWars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static exercicioExcecaoCodeWars.FindOutLier.encontrarExcecao;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindOutLierTest {
    @Test
    @DisplayName("Deve encontrar o número que é uma excessão entre 3 arrays.")
    public void encontrarExcecaoTest() {
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};

        //verificando se lida bem com o valor maximo de um inteiro
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};

        assertEquals(3, encontrarExcecao(exampleTest1));
        assertEquals(206847684, encontrarExcecao(exampleTest2));
        assertEquals(0, encontrarExcecao(exampleTest3));
    }
}
