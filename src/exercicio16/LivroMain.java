package exercicio16;

public class LivroMain {
    public static void main(String[] args) {
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "HarperCollins", 1954);

        System.out.println("Título do livro: " + livro1.getTitulo());
        System.out.println("Autor: " + livro1.getAutor());
        System.out.println("Editora: " + livro1.getEditora());
        System.out.println("Ano de lançamento: " + livro1.getAnoLancamento());

        if (livro1.isEmprestado()) {
            System.out.println("O livro está emprestado e deve ser devolvido até " + livro1.getDataDevolucao());
        } else {
            System.out.println("O livro não está emprestado.");
        }
    }
}

