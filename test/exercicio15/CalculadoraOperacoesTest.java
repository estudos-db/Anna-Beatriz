package exercicio15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraOperacoesTest {
    @Test
    @DisplayName("Deve calcular a soma, simulando o número 4 somado à 2.")
    public void testSomar() {
        double resultado = CalculadoraOperacoes.somar(4.0, 2.0);
        assertEquals(6.0, resultado, 0.00001);
    }
    @Test
    @DisplayName("Deve calcular a subtração, simulando o número 4 subtraído por 2.")
    public void testSubtrair() {
        double resultado = CalculadoraOperacoes.subtrair(4.0, 2.0);
        assertEquals(2.0, resultado, 0.00001);
    }
    @Test
    @DisplayName("Deve calcular a multiplicação, simulando o número 4 multiplicado por 2.")
    public void testMultiplicar() {
        double resultado = CalculadoraOperacoes.multiplicar(4.0, 2.0);
        assertEquals(8.0, resultado, 0.00001);
    }
    @Test
    @DisplayName("Deve calcular a divisão, simulando o número 4 dividido por 2.")
    public void testDividir() {
        double resultado = CalculadoraOperacoes.dividir(4.0, 2.0);
        assertEquals(2, resultado, 0.00001);
    }
    @Test
    @DisplayName("Deve calcular a potenciação, simulando a base 4 e expoente 2.")
    public void testPotencia() {
        double resultado = CalculadoraOperacoes.potencia(4.0, 2.0);
        assertEquals(16.0, resultado, 0.00001);
    }
}
