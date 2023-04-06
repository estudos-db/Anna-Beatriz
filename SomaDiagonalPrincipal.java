package testjava;

public class SomaDiagonalPrincipal {
    public static void main(String[] args) {
        int[][] matriz = { {0,1,2}, {3,4,5}, {6,7,8} }; //primeira, segunda e terceira linha da matriz respectivamente

        int somaDiagonalPrincipal = CalculadoraSoma.CalcularSomaDaDiagonalPrincipal(matriz);
        System.out.println("A soma da diagonal principal é: " + somaDiagonalPrincipal);
    }

    class CalculadoraSoma {
        public static int CalcularSomaDaDiagonalPrincipal(int[][] matriz) {
            int soma = 0;

            for (int linha = 0; linha < matriz.length; linha++) {
                int coluna = linha;
                soma += matriz[linha][coluna];
            }
            return soma;
        }
    }
}
