package exercicioLutaEntreNinjas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JutsuTest {
       Jutsu jutsu = new Jutsu("Chidori", 10, 5);

    @Test
    public void testSetDanoInvalido() {
     IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> jutsu.setDano(-10)
        );
     String mensagemEsperada = "O dano não pode ser negativo.";
     String mensagemRecebida = exception.getMessage();
     Assertions.assertTrue(mensagemRecebida.contains(mensagemEsperada));
    }

    @Test
    public void testSetConsumoDeChakraInvalido() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> jutsu.setConsumoDeChakra(-5)
        );
        String mensagemEsperada = "O consumo de chakra não pode ser negativo.";
        String mensagemRecebida = exception.getMessage();
        Assertions.assertTrue(mensagemRecebida.contains(mensagemEsperada));
    }
}
