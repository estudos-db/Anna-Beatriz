package exercicio16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroTest {
    Livro livro = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Rocco", 1999);
    @Test
    public void testGetTitulo() {
        assertEquals("Harry Potter e a Pedra Filosofal", livro.getTitulo());
    }
    @Test
    public void testGetAutor() {
        assertEquals("J.K. Rowling", livro.getAutor());
    }
    @Test
    public void testGetEditora() {
        assertEquals("Rocco", livro.getEditora());
    }
    @Test
    public void testGetAnoLancamento() {
        assertEquals(1999, livro.getAnoLancamento());
    }
}
