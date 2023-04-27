package exercicio16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    Pessoa pessoa = new Pessoa("João");
    @Test
    @DisplayName("Deve retornar o nome de uma pessoa.")
    public void testGetNome() {
        Assertions.assertEquals("João", pessoa.getNome());
    }
}
