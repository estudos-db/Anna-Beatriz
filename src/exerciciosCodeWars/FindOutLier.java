package exerciciosCodeWars;
/*Você recebe um array (que terá um comprimento de pelo menos 3, mas pode ser muito grande)
contendo números inteiros. O array é composto inteiramente por números ímpares ou inteiramente por números pares,
exceto por um único número N. Escreva um método que receba o array como argumento e retorne esse número
"excepcional" N.
 */
public class FindOutLier {
    public static void main(String[] args) {
        int[] array1 = {2, 4, 0, 100, 4, 11, 2602, 36};
        int excecao1 = encontrarExcecao(array1);
        if (excecao1 != -1) {
            System.out.println("Exceção 1: " + excecao1 + " é ímpar.");
        } else {
            System.out.println("Nenhum número de exceção foi encontrado no array1.");
        }

        int[] array2 = {160, 3, 1719, 19, 11, 13, -21};
        int excecao2 = encontrarExcecao(array2);
        if (excecao2 != -1) {
            System.out.println("Exceção 2: " + excecao2 + " é par.");
        } else {
            System.out.println("Nenhum número de exceção foi encontrado no array2.");
        }
    }

    public static int encontrarExcecao(int[] numeros) {
        boolean pares = numeros[0] % 2 == 0 && numeros[1] % 2 == 0 || numeros[0] % 2 == 0 && numeros[2] % 2 == 0 || numeros[1] % 2 == 0 && numeros[2] % 2 == 0;

        for (int numero : numeros) {
            if (pares && numero % 2 != 0) {
                return numero;
            } else if (!pares && numero % 2 == 0) {
                return numero;
            }
        }

        return -1; // Retornar um valor especial para indicar que nenhum número excepcional foi encontrado
    }
}
