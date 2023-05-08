package exercicioNaruto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NinjaDeNinjutsuTest {
    private NinjaDeNinjutsu ninja;

    @BeforeEach
    public void setup() {
        ninja = new NinjaDeNinjutsu("Naruto", 17, "Konoha", 15);
    }

    @Test
    @DisplayName("Deve fazer um ninja usar um jutsu")
    public void testUsarJutsu() {
        String expected = "O ninja Naruto está usando um jutsu de Ninjutsu";
        String actual = ninja.usarJutsu();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Deve fazer um ninja desviar de um ataque.")
    public void testDesviar() {
        String expected = "O ninja Naruto está desviando de um ataque usando sua habilidade em Ninjutsu";
        String actual = ninja.desviar();
        assertEquals(expected, actual);
    }
}
