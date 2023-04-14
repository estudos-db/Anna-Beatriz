package src.exercicio13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoTest {
    @Test

    @DisplayName("Deve calcular a média de um aluno, verificando se a média calculada é igual a 6.")
    public void testCalcularMedia() {
        Aluno aluno = new Aluno(6.0, 7.0, 8.0, 9.3);
        double media = aluno.calcularMedia();
        assertEquals(7.575, media);
    }
    @Test

    @DisplayName("Deve informar o status do aluno com situações de aprovação, verificação e reprovação.")
    public void testInformarStatusDoAluno() {
        Aluno aluno1 = new Aluno(6.0, 7.0, 8.0, 9.3);
        assertEquals("Aprovado.", aluno1.informarStatusDoAluno());

        Aluno aluno2 = new Aluno(5.0, 4.0, 5.0, 5.0);
        assertEquals("Verificação Suplementar.", aluno2.informarStatusDoAluno());


        Aluno aluno3 = new Aluno(3.0, 0.0, 2.0, 3.0);
        assertEquals("Reprovado.", aluno3.informarStatusDoAluno());
    }
}
