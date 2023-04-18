package exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarroTest {
    @Test
    @DisplayName("Deve ligar o carro.")
    public void testarMetodoLigar() {
        Carro carro = new Carro("Fiat", "Palio", 2010, "vermelho");
        assertFalse(carro.isLigado());
        carro.ligar();
        assertTrue(carro.isLigado());
    }
}
