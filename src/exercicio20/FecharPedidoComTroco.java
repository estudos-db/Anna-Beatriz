package exercicio20;

import java.math.BigDecimal;
import java.util.Scanner;

public class FecharPedidoComTroco {
    private final Scanner scanner = new Scanner(System.in);
    public void realizarPedido() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem();

        try {
            boolean decisao = true;
            while (decisao) {
                System.out.println("Deseja adicionar mais um item na lista? S(sim) ou N(não) ?");
                String resposta = scanner.next().toUpperCase();
                scanner.nextLine();
                switch (resposta) {
                    case "S" -> {
                        Produto produto = pedido.encontrarProduto();
                        while (produto == null) {
                            produto = pedido.encontrarProduto();
                        }
                        int quantidadeRequerida = pedido.receberQuantidadeProdutoDoTeclado();
                        Estoque.temEstoqueOuNao(produto.getNome(), quantidadeRequerida);

                        Item item = new Item(produto, quantidadeRequerida);
                        Estoque.darBaixaEmEstoque(produto.getNome(), quantidadeRequerida);

                        pedido.adicionarItemALista(item);
                        pedido.calcularValorTotal();
                    }
                    case "N" -> decisao = false;
                    default -> {
                        System.out.println("Resposta inválida. Por favor, insira S ou N.");
                    }
                }
            }

            fecharPedido(pedido.getValorTotal());
            pedido.imprimirPedido();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void fecharPedido(BigDecimal valorPedido) {
        System.out.println("O valor do pedido é " + valorPedido);
        System.out.println("Qual o valor que você tem?");
        BigDecimal valorPagoEmDinheiro = scanner.nextBigDecimal();

        if (valorPagoEmDinheiro.compareTo(valorPedido) < 0) {
            throw new RuntimeException("O dinheiro fornecido é insuficiente para finalizar o seu pedido. Adicione mais dinheiro ou altere sua compra.");
        } else if (valorPagoEmDinheiro.compareTo(valorPedido) == 0) {
            System.out.println("Quantia exata! Não será necessário troco :)");
        } else {
            BigDecimal troco = valorPagoEmDinheiro.subtract(valorPedido);
            System.out.println("O troco é " + troco + ".");
        }
    }
}

