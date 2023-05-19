package exerciciosCodeWars;

import org.junit.jupiter.api.Test;

import static exerciciosCodeWars.Sum.somarInteiros;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    @Test
    public void testSomarInteiros() {
        assertEquals(-1, somarInteiros(0, -1));
        assertEquals(1, somarInteiros(1, 1));
        assertEquals(6, somarInteiros(1, 3));
        assertEquals(-6, somarInteiros(-3, -1));
        assertEquals(10, somarInteiros(0, 4));
    }
}
