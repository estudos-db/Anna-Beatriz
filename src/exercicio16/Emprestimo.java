package exercicio16;

import java.time.LocalDate;

public class Emprestimo {
    private final Livro livro;
    private final Pessoa pessoa;
    private final LocalDate dataEmprestimo;
    private LocalDate dataParaDevolucao;

    public Emprestimo(Livro livro, Pessoa pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
        this.dataEmprestimo = LocalDate.now();
        this.dataParaDevolucao = dataEmprestimo.plusDays(7); // prazo de devolução de 7 dias
    }

    public void setDataParaDevolucao(LocalDate dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
        livro.setDataDevolucao(dataParaDevolucao);
    }

    public boolean emprestimoAtivo() {
        return LocalDate.now().isBefore(dataParaDevolucao);
    }
    public Livro getLivro() {
        return livro;
    }
    public void devolverLivro() {
        if (emprestimoAtivo()) {
            livro.devolver();
            System.out.println("O livro foi devolvido, mas com entrega atrasada.");
        } else {
            livro.devolver();
            System.out.println("O livro foi devolvido, mas com entrega atrasada.");
        }
    }
    public void realizarEmprestimo() {
        livro.emprestar(pessoa);
    }
}
