package exercicioNaruto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NinjaDeGenjutsuTest {
    @Test
    @DisplayName("Deve fazer um ninja usar um jutsu")
    public void testUsarJutsu() {
        NinjaDeGenjutsu ninja = new NinjaDeGenjutsu("Sasuke", 16, "Konoha", 10);
        String result = ninja.usarJutsu();
        Assertions.assertEquals("O ninja Sasuke está usando um jutsu de Genjutsu", result);
    }

    @Test
    @DisplayName("Deve fazer um ninja desviar de um ataque.")
    public void testDesviar() {
        NinjaDeGenjutsu ninja = new NinjaDeGenjutsu("Sasuke", 16, "Konoha", 10);
        String result = ninja.desviar();
        Assertions.assertEquals("O ninja Sasuke está desviando de um ataque usando sua habilidade em Genjutsu", result);
    }
}
