package exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuinchoTest {
    @Test
    @DisplayName("Deve carregar um automóvel carro.")
    public void testCarregar() {
        Guincho guincho = new Guincho();
        Automovel carro = new Automovel("Honda", "Civic", 2022, "Cinza");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream); // redirecionar a saída para o objeto em memoria

        guincho.carregar(carro);
        assertEquals("Guincho carregando automóvel Honda Civic.\n", outputStream.toString());

        System.setOut(System.out);
    }
}