
package exercicio15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculadoraMenuTest {
    @Test
    @DisplayName("Deve exibir o menu da calculadora.")
    public void testExibirMenu() {
        CalculadoraMenu.exibirMenu();
        // Se não houver exceção, o teste passa
        assertTrue(true);
    }
}