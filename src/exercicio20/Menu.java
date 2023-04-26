package exercicio20;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final FecharPedidoComTroco pedido = new FecharPedidoComTroco();

    private static final int OPCAO_EXIBIR_ESTOQUE = 1;
    private static final int OPCAO_REALIZAR_PEDIDO = 2;
    private static final int OPCAO_CADASTRAR_PRODUTO = 3;
    private static final int OPCAO_ENCERRAR_PROGRAMA = 4;

    public void iniciaMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean decisao = true;
            while (decisao) {
                int resposta;
                mostrarMenu();
                try {
                    resposta = scanner.nextInt();
                } catch (InputMismatchException excecao) {
                    scanner.nextLine();
                    resposta = 0;
                }
                switch (resposta) {
                    case OPCAO_EXIBIR_ESTOQUE -> Estoque.mostrarEstoque();
                    case OPCAO_REALIZAR_PEDIDO -> pedido.realizarPedido();
                    case OPCAO_CADASTRAR_PRODUTO -> Estoque.cadastrarProduto();
                    case OPCAO_ENCERRAR_PROGRAMA -> {
                        System.out.println("encerrando o programa...");
                        decisao = false;
                    }
                    case 0 -> System.out.println("Opção inválida, digite novamente.");
                }
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("Qual das ações abaixo você gostaria de realizar?");
        System.out.println(OPCAO_EXIBIR_ESTOQUE + ": para exibir estoque");
        System.out.println(OPCAO_REALIZAR_PEDIDO + ": para realizar um pedido");
        System.out.println(OPCAO_CADASTRAR_PRODUTO + ": para cadastrar um produto");
        System.out.println(OPCAO_ENCERRAR_PROGRAMA + ": para encerrar o programa");
    }
}
