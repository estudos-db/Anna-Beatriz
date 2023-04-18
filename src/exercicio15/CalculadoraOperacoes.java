package exercicio15;

public class CalculadoraOperacoes {
    public static double somar(double a, double b) {
        return a + b;
    }
    public static double subtrair(double a, double b) {
        return a - b;
    }
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    public static double dividir(double a, double b){
        if (b == 0) {
            throw new IllegalArgumentException("O divisor não pode ser zero. Insira outro número.");
        }
        return a / b;
    }
    public static double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }
}

