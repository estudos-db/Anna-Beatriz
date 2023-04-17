package exercicio16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmprestimoTest {
    @Test
    void testSetDataParaDevolucao() {
        Emprestimo emprestimo = new Emprestimo(new Livro("Livro de teste", "Autor de teste", "Editora de teste", 2022), new Pessoa("João"));
        LocalDate data = LocalDate.now().plusDays(7);
        emprestimo.setDataParaDevolucao(data);
        Assertions.assertEquals(data, emprestimo.getLivro().getDataDevolucao());
    }
    @Test
    void testDevolverLivroSemEntregaAtrasada() {
        Emprestimo emprestimo = new Emprestimo(new Livro("Livro de teste", "Autor de teste", "Editora de teste", 2022), new Pessoa("João"));
        emprestimo.realizarEmprestimo();
        emprestimo.setDataParaDevolucao(LocalDate.now().plusDays(7));
        emprestimo.devolverLivro();
        Livro livro = emprestimo.getLivro();
        Assertions.assertFalse(livro.isEmprestado());
        Assertions.assertFalse(livro.isAtrasado());
    }

    @Test
    void testRealizarEmprestimo() {
        Emprestimo emprestimo = new Emprestimo(new Livro("Livro tal", "Autor tal", "Editora tal", 2023), new Pessoa("João"));
        emprestimo.realizarEmprestimo();
        Assertions.assertTrue(emprestimo.getLivro().isEmprestado());
    }

    @Test
    void testEmprestimoAtivo() {
        Emprestimo emprestimo = new Emprestimo(new Livro("Livro tal", "Autor tal", "Editora tal", 2023), new Pessoa("João"));
        emprestimo.realizarEmprestimo();
        emprestimo.setDataParaDevolucao(LocalDate.now().plusDays(7));
        Assertions.assertTrue(emprestimo.emprestimoAtivo());
        emprestimo.setDataParaDevolucao(LocalDate.now().minusDays(1));
        Assertions.assertFalse(emprestimo.emprestimoAtivo());
    }
}