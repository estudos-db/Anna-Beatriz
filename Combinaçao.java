
public class Combinaçao {
    public static boolean checarASoma(int[] numeros, int k) {
        for (int i = 0; i < numeros.length; i++) {
            /*incrementar garante que cada numero da lista seja utilizado pelo
            menos uma vez como um dos valores da soma. assim a variavel i tem o valor 1 e o segundo
            elemento é acessado como a lista de numeros[1], sucessivamente.
             */
            for (int f = i + 1; f < numeros.length; f++) {
                /*necessario assegurar que o loop f percorre a lista a partir do elemento seguinte ao atual
                do loop externo ou ele fica preso em uma comparaçao infinita entre os mesmos 2 elementos,
                ja que a variavel i nunca iria atualizar.
                */

                if (numeros[i] + numeros[f] == k) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int k = 17;
        int[] numeros = {10, 15, 3, 7};
        boolean resultado = checarASoma(numeros, k);
        System.out.println(resultado);
    }
}
