package exercicio19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoTest {
    Endereco endereco = new Endereco("Rua A", 10, "Cidade", "Estado", "Bairro");
    @Test
    @DisplayName("Deve trazer a correta representação textual da instância do objeto endereço.")
    public void testToString() {
        assertEquals("Rua A, 10 - Bairro - Cidade - Estado.", endereco.toString());
    }
}
