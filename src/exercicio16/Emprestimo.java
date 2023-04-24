package exercicio16;

import java.time.LocalDate;

public class Emprestimo {
    private final Livro livro;
    private final LocalDate dataEmprestimo;
    private LocalDate dataParaDevolucao;
    private Pessoa emprestadoPara;
    private boolean emprestado;

    public Emprestimo(Livro livro, Pessoa pessoa) {
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataParaDevolucao = dataEmprestimo.plusDays(7); // prazo de devolução de 7 dias
        this.emprestadoPara = null;
        this.emprestado = false;
    }

    public void setDataParaDevolucao(LocalDate dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
    }
    public boolean isEmprestado() {
        return emprestado;
    }
    public Pessoa getEmprestadoPara() {
        return emprestadoPara;
    }
    public LocalDate getDataParaDevolucao() {
        return dataParaDevolucao;
    }
    public boolean isAtrasado() {
        if (dataParaDevolucao == null) {
            return false;
        }
        return LocalDate.now().isAfter(dataParaDevolucao);
    }
    public boolean emprestimoAtivo() {
            LocalDate.now();
        return LocalDate.now().isBefore(dataParaDevolucao);
    }
    public Livro getLivro() {
        return livro;
    }
    public void livroDevolvido() {
        if (emprestimoAtivo()) {
            devolver();
            System.out.println("O livro foi devolvido, mas com entrega atrasada.");
        } else {
            devolver();
            System.out.println("O livro foi devolvido, mas com entrega atrasada.");
        }
    }
    public void realizarEmprestimo(Pessoa pessoa) {
        if (!emprestado) {
            emprestado = true;
            this.dataParaDevolucao = LocalDate.now().plusDays(7); // prazo de devolução de 7 dias
            this.emprestadoPara = pessoa;
            System.out.println("Livro \"" + livro.getTitulo() + "\" emprestado para " + pessoa.getNome() + ". Data de devolução: " + dataParaDevolucao);
        } else {
            System.out.println("Este livro já está emprestado para " + emprestadoPara.getNome() + ".");
        }
    }
    public void devolver() {
        if (emprestado) {
            emprestado = false;
            this.dataParaDevolucao = null;
            System.out.println("Livro \"" + livro.getTitulo() + "\" devolvido.");
        } else {
            System.out.println("Este livro não está emprestado.");
        }
    }
}
