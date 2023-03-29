package testjava;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContarFibonacciAteCertoNumeroTest {
    @Test
    public void testContarFibonacciAteCertoNumero() {
        //sequência gerada pra alguns valores de entrada
        assertEquals("0,1,1,2,3,5,8,", sequenciaFibonacci(10));
        assertEquals("0,1,1,2,3,5,8,13,21,34,", sequenciaFibonacci(35));
        assertEquals("0,1,1,2,3,", sequenciaFibonacci(3));
    }
    private String sequenciaFibonacci(int numero) {
        int a = 0, b = 1, c;
        String resultado = "";

        while (a <= numero) {
            resultado += a + ",";
            c = a + b;
            a = b;
            b = c;
        }
        return resultado;
    }
}