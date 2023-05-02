package exercicioNaruto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NinjaDeTaijutsuTest {
    @Test
    @DisplayName("Deve indicar que o chakra de um ninja de taijutsu é nulo.")
    public void testSetChakra() {
        assertThrows(IllegalArgumentException.class, () -> {
            NinjaDeTaijutsu ninja = new NinjaDeTaijutsu("Rock Lee", 17, "Konoha", 0);
            ninja.setChakra(15);
        });
    }
}
