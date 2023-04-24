package exercicio17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {
    Pessoa avoPaterno = new Pessoa("Luiz", 80, null, null);
    Pessoa avoPaterna = new Pessoa("Ana", 75, null, null);
    Pessoa pai = new Pessoa("João", 50, avoPaterno, avoPaterna);
    Pessoa filho = new Pessoa("Pedro", 20, pai, null);
    Pessoa pessoa = new Pessoa("João", 30, null, null);
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
        Pessoa avoMaterna = new Pessoa("Clara", 80, null, null);
        Pessoa mae = new Pessoa("Maria", 45, null, avoMaterna);
        assertEquals(mae, filho.getMae());
    }

    @Test
    @DisplayName("Deve retornar, em string , a representação da pessoa correta.")
    void testToString() {
        String expected = "Pessoa{nome='Pedro', idade=20, pai=Pessoa{nome='João', idade=50, pai=Pessoa{nome='Luiz', idade=80, pai=null, mae=null}, mae=Pessoa{nome='Ana', idade=75, pai=null, mae=null}}, mae=null}";
        assertEquals(expected, filho.toString());
    }
}
