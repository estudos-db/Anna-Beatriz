import java.util.Arrays;

public class ProdutoDoArray {
    public static void main(String[] args) {
        //array original do desafio
        int[] array = {1, 2, 3, 4, 5};

        //percorre o array interior e cria um novo array pra armazenar os resultados
        int[] novoArray = new int[array.length];

        int produto = 1;

        //percorre o array original e encontra o produto total
        for (int i = 0; i < array.length; i++) {
            produto *= array[i];
        }

        //pra cada elemento do array, o produto total é dividido pelo atual e armazena o resultado
        for (int i = 0; i < array.length; i++) {
            novoArray[i] = produto / array[i];
        }

        System.out.println(Arrays.toString(novoArray));
    }
}
