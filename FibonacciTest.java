package testjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class FibonacciTest {

    @Test
    public void testGerarSequencia() {
        Fibonacci fibonacci = new Fibonacci();
        List<Integer> sequenciaEsperada = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);

        List<Integer> sequenciaGerada = fibonacci.gerarSequencia(9);

        Assertions.assertEquals(sequenciaEsperada, sequenciaGerada);
    }
}