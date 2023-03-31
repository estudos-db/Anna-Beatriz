package testjava;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContarFibonacciAteCertoNumeroTest {
//testa sequencias de entrada
    @Test
    public void testSequenciaFibonacci() {

        String resultadoEsperado1 = "0,1,1,2,3,5,";
        String resultadoObtido1 = ContarFibonacciAteCertoNumero.sequenciaFibonacci(5);
        Assertions.assertEquals(resultadoEsperado1, resultadoObtido1);

        String resultadoEsperado2 = "0,1,1,2,3,5,8,";
        String resultadoObtido2 = ContarFibonacciAteCertoNumero.sequenciaFibonacci(10);
        Assertions.assertEquals(resultadoEsperado2, resultadoObtido2);

        //testa entrada negativa
        String resultadoEsperado3 = "";
        String resultadoObtido3 = ContarFibonacciAteCertoNumero.sequenciaFibonacci(-1);
        Assertions.assertEquals(resultadoEsperado3, resultadoObtido3);
    }
}
