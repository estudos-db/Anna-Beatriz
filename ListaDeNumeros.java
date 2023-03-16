import java.util.*;
 /*Dado uma lista de números e um número K, retornar true SE dentro da lista de números existir
 alguma combinação de soma de números que resulte em K. Exemplo: Dada a lista[10, 15, 3, 7] e o K = 17,
 returnar true dado que dentro da lista de números existe 10 e 7, que somados resultam em K = 17.*/
public class ListaDeNumeros {
    public static boolean SomaDosNumeros(List<Integer> numbers, int k) {
        Set<Integer> vistos = new HashSet<>(); /*vistos são os numeros inteiros vistos até o momento e para cada número
        n na lista, verifica se a diferença entre k e n já foi vista antes no conjunto "vistos".*/

        for (int n : numbers) {
            if (vistos.contains(k - n)) return true;
            vistos.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,15,3,7);
        int k = 17;
        boolean SomaDosNumeros = SomaDosNumeros(numbers, k);
        System.out.println(SomaDosNumeros);
    }
}