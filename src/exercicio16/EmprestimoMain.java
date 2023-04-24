package exercicio16;
import java.time.LocalDate;
public class EmprestimoMain {
        public static void main(String[] args) {
                Pessoa pessoa1 = new Pessoa("João");
                Pessoa pessoa2 = new Pessoa("Maria");

                Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "HarperCollins", 1954);
                Livro livro2 = new Livro("A metamorfose", "Franz Kafka", "Editora Antofógica", 1915);

                Emprestimo emprestimo1 = new Emprestimo(livro1, pessoa1);
                Emprestimo emprestimo2 = new Emprestimo(livro2, pessoa2);

                emprestimo1.realizarEmprestimo(pessoa1);
                emprestimo2.realizarEmprestimo(pessoa2);

                emprestimo1.setDataParaDevolucao(LocalDate.now().minusDays(2));
                emprestimo2.setDataParaDevolucao(LocalDate.now().minusDays(3));

                emprestimo1.livroDevolvido();
                emprestimo2.livroDevolvido();
        }
}
