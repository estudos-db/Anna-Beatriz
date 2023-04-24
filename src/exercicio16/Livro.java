package exercicio16;

public class Livro {
    private String titulo;
    private final String autor;
    private final String editora;
    private final int anoLancamento;

    public Livro(String titulo, String autor, String editora, int anoLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoLancamento = anoLancamento;
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
}
