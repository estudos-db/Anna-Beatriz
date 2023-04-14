package src.exercicio13;

import src.exercicio13.*;

public class AlunoMain {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(7.5, 5.0, 3.0, 3.0);
        String status = aluno1.informarStatusDoAluno();
        System.out.println("Status do aluno: " + status);
    }
}
