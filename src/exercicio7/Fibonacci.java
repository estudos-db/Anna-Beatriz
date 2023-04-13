package exercicio7;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static List<Integer> gerarSequencia(int numero) {
        List<Integer> sequencia = new ArrayList<>();

        //primeiros valores da sequencia fibonacci, variavel c armazena soma
        int numeroAnterior = 0, numeroAtual = 1, soma;

        sequencia.add(numeroAnterior);
        sequencia.add(numeroAtual);

        //a cada iteraçao, variavel c é atualizada
        for (int i = 1; i < numero; i++) {
            soma = numeroAnterior + numeroAtual;
            sequencia.add(soma);

            //atualiza os valores anteriores para a proxima iteraçao
            numeroAnterior = numeroAtual;
            numeroAtual = soma;
        }
        return sequencia;
    }
}