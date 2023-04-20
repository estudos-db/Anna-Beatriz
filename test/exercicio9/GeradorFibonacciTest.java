package exercicio9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeradorFibonacciTest {
//testa sequencias de entrada
    @Test
    public void testSequenciaFibonacci() {

        String resultadoEsperado1 = "0,1,1,2,3,5,";
        String resultadoObtido1 = GeradorFibonacci.sequenciaFibonacci(5);
        Assertions.assertEquals(resultadoEsperado1, resultadoObtido1);

        String resultadoEsperado2 = "0,1,1,2,3,5,8,";
        String resultadoObtido2 = GeradorFibonacci.sequenciaFibonacci(10);
        Assertions.assertEquals(resultadoEsperado2, resultadoObtido2);

        //testa entrada negativa
        String resultadoEsperado3 = "";
        String resultadoObtido3 = GeradorFibonacci.sequenciaFibonacci(-1);
        Assertions.assertEquals(resultadoEsperado3, resultadoObtido3);
    }
}
