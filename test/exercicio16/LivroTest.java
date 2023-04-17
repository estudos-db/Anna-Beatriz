package exercicio16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LivroTest {
    @Test
    public void testEmprestar() {
        Livro livro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "HarperCollins", 1954);
        Pessoa pessoa = new Pessoa("João");

        livro.emprestar(pessoa);

        Assertions.assertTrue(livro.isEmprestado());
        Assertions.assertEquals(pessoa, livro.getEmprestadoPara());
        Assertions.assertEquals(LocalDate.now().plusDays(7), livro.getDataDevolucao());
    }

    @Test
    public void testDevolver() {
        Livro livro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "HarperCollins", 1954);
        Pessoa pessoa = new Pessoa("João");

        livro.emprestar(pessoa);
        livro.devolver();

        Assertions.assertFalse(livro.isEmprestado());
        Assertions.assertNull(livro.getDataDevolucao());
    }
}
