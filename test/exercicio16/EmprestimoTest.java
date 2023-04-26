package exercicio16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmprestimoTest {
    Livro livro = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Rocco",1999);
    Pessoa pessoa = new Pessoa("Maria Souza");
    Emprestimo emprestimo = new Emprestimo(livro, pessoa);
    LocalDate novaData = LocalDate.now().plusDays(10);
    @Test
    public void testSetDataParaDevolucao() {
        emprestimo.setDataParaDevolucao(novaData);
        assertEquals(novaData, emprestimo.getDataParaDevolucao());
    }
    @Test
    void testDevolverLivroSemEntregaAtrasada() {
        emprestimo.realizarEmprestimo(new Pessoa("Maria"));
        emprestimo.setDataParaDevolucao(LocalDate.now().plusDays(7));
        emprestimo.livroDevolvido();
        Livro livro = emprestimo.getLivro();
        Assertions.assertFalse(emprestimo.isEmprestado());
        Assertions.assertFalse(emprestimo.isAtrasado());
    }

    @Test
    public void testRealizarEmprestimo() {
        emprestimo.realizarEmprestimo(pessoa);
        assertTrue(emprestimo.isEmprestado());
        assertEquals(pessoa, emprestimo.getEmprestadoPara());
        assertEquals(LocalDate.now().plusDays(7), emprestimo.getDataParaDevolucao());
    }

    @Test
    void testEmprestimoAtivo() {
        emprestimo.realizarEmprestimo(new Pessoa("João"));
        emprestimo.setDataParaDevolucao(LocalDate.now().plusDays(7));
        assertTrue(emprestimo.emprestimoAtivo());
        emprestimo.setDataParaDevolucao(LocalDate.now().minusDays(1));
        Assertions.assertFalse(emprestimo.emprestimoAtivo());
    }


}