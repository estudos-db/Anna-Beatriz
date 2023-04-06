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
            

            /* o loop for percorre todas as linhas da matriz. a variavel "linha" é iniciada com 0
             porque representa a primeira linha da matriz e enquanto a variável "linha" for menor
             que o tamanho da matriz (número de linhas da matriz), o loop vai continuar executando.
             a cada iteraçao desse loop o valor da variavel "linha" é incrementado em 1 e o loop
             percorre as proximas linhas da matriz.
             */
            for (int linha = 0; linha < matriz.length; linha++) {

             //armazena a coluna correspondente a linha atual.
                int coluna = linha;
                
             /*adiciona o valor armazenado na posição correspondente à linha e
                coluna atual da matriz à variável soma.*/
                soma += matriz[linha][coluna];
            }
            return soma;
        }
    }
}
