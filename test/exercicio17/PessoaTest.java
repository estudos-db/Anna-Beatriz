package exercicio17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {
    Pessoa pai = new Pessoa("João", 50);
    Pessoa mae = new Pessoa("Maria", 45);
    Pessoa filho = new Pessoa("Pedro", 20, pai, mae);
    Pessoa pessoa = new Pessoa("João", 30);
    @Test
    @DisplayName("Deve retornar o nome da pessoa.")
    void testGetNome() {
        assertEquals("João", pessoa.getNome());
    }

    @Test
    @DisplayName("Deve retornar a idade da pessoa.")
    void testGetIdade() {
        assertEquals(30, pessoa.getIdade());
    }

    @Test
    @DisplayName("Deve retornar o pai correto da pessoa.")
    void testGetPai() {
        assertEquals(pai, filho.getPai());
    }

    @Test
    @DisplayName("Deve retornar a mãe correta da pessoa.")
    void testGetMae() {
        assertEquals(mae, filho.getMae());
    }

    @Test
    @DisplayName("Deve retornar, em string , a representação da pessoa correta.")
    void testToString() {
        Pessoa pessoa = new Pessoa("João", 30);
        String expected = "Pessoa{nome='João', idade=30}";
        String actual = pessoa.toString();
        Assertions.assertEquals(expected, actual);
    }
}
