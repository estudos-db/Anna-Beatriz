package exercicio16;

import java.time.LocalDate;
public class Livro {
    private String titulo;
    private final String autor;
    private final String editora;
    private final int anoLancamento;
    private boolean emprestado;
    private LocalDate dataDevolucao;
    private Pessoa emprestadoPara;
    public Livro(String titulo, String autor, String editora, int anoLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoLancamento = anoLancamento;
        this.emprestado = false;
        this.dataDevolucao = null;
        this.emprestadoPara = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isEmprestado() {
        return emprestado;
    }
    public Pessoa getEmprestadoPara() {
        return emprestadoPara;
    }


    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public boolean isAtrasado() {
        if (dataDevolucao == null) {
            return false;
        }
        return LocalDate.now().isAfter(dataDevolucao);
    }
    public void emprestar(Pessoa pessoa) {
        if (!emprestado) {
            emprestado = true;
            this.dataDevolucao = LocalDate.now().plusDays(7); // prazo de devolução de 7 dias
            this.emprestadoPara = pessoa;
            System.out.println("Livro \"" + titulo + "\" emprestado para " + pessoa.getNome() + ". Data de devolução: " + dataDevolucao);
        } else {
            System.out.println("Este livro já está emprestado para " + emprestadoPara.getNome() + ".");
        }
    }

    public void devolver() {
        if (emprestado) {
            emprestado = false;
            this.dataDevolucao = null;
            System.out.println("Livro \"" + titulo + "\" devolvido.");
        } else {
            System.out.println("Este livro não está emprestado.");
        }
    }
}
