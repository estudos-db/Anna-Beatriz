package exercicio16;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int anoLancamento;

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
    public void setAutor(String autor) { this.autor = autor; }
    public void setEditora(String editora) { this.editora = editora; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }
}

