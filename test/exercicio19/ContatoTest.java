package exercicio19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContatoTest {
    String nome = "João";
    String sobrenome = "Silva";
    String telefone = "(81) 91111-1111";
    String email = "joaosilva@gmail.com";
    Endereco endereco = new Endereco("Rua Tal", 123, "Cidade Assim", "Estado Assado", "Bairro Tal");
    Contato contato = new Contato(nome, sobrenome, telefone, email, endereco);

    @Test
    public void testToString() {
        String expected = nome + " " + sobrenome + " - " + email + " - " + telefone + " - " + endereco;
        Assertions.assertEquals(expected, contato.toString());
    }
}
