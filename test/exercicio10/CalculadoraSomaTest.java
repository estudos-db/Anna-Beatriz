package exercicio10;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraSomaTest {

    @Test
    public void testCalcularSomaDaDiagonalPrincipal() {
        int[][] matriz1 = { {0,1,2}, {3,4,5}, {6,7,8} };
        int resultadoEsperado1 = 12;
        int resultadoObtido1 = SomaDiagonalPrincipal.CalculadoraSoma.CalcularSomaDaDiagonalPrincipal(matriz1);
        assertEquals(resultadoEsperado1, resultadoObtido1);

        int[][] matriz2 = { {9,10,11}, {12,13,14}, {15,16,17} };
        int resultadoEsperado2 = 39;
        int resultadoObtido2 = SomaDiagonalPrincipal.CalculadoraSoma.CalcularSomaDaDiagonalPrincipal(matriz2);
        assertEquals(resultadoEsperado2, resultadoObtido2);
    }
}