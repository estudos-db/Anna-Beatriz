package exercicio16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    @Test
    @DisplayName("Deve retornar o nome de uma pessoa.")
    public void testGetNome() {
        Pessoa pessoa = new Pessoa("João");
        Assertions.assertEquals("João", pessoa.getNome());
    }
}
