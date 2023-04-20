package src.exercicio13;
public class Aluno {
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    static String statusDoAluno;

    public Aluno(double nota1, double nota2, double nota3, double nota4) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3 + nota4) / 4.0;
    }

    public String informarStatusDoAluno() {
        double media = calcularMedia();
        if (media >= 6) {
            statusDoAluno = "Aprovado.";
        } else if (media >= 4) {
            statusDoAluno = "Verificação Suplementar.";
        } else {
            statusDoAluno = "Reprovado.";
        }
        return statusDoAluno;
    }
}