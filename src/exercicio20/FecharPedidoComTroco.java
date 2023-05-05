package exercicio20;

import java.math.BigDecimal;
import java.util.Scanner;

public class FecharPedidoComTroco {
    private static final Scanner scanner = new Scanner(System.in);
    public static void realizarPedido() {
        Pedido pedido = new Pedido();

        pedido.realizarBuscaPorItem();

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
                        System.out.println("Opção inválida. Por favor, insira S ou N.");
                    }
                }
            }

            fecharPedido(pedido.getValorTotal());
            pedido.imprimirPedido();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fecharPedido(BigDecimal valorPedido) {
        System.out.println("O valor do pedido é R$" + valorPedido + ".");
        System.out.println("Qual o valor que você tem para realizar pagamento?");
        BigDecimal valorPagoEmDinheiro = scanner.nextBigDecimal();

        BigDecimal troco = calcularTroco(valorPedido, valorPagoEmDinheiro);
        if (troco.compareTo(BigDecimal.ZERO) > 0) {
            calcularMenorQuantidadeDeNotas(troco);
        }
    }
    public static BigDecimal calcularTroco(BigDecimal valorPedido, BigDecimal valorPagoEmDinheiro) {
        if (valorPagoEmDinheiro.compareTo(valorPedido) < 0) {
            throw new RuntimeException("O dinheiro fornecido é insuficiente para finalizar o seu pedido. Adicione mais dinheiro ou altere sua compra.");
        } else if (valorPagoEmDinheiro.compareTo(valorPedido) == 0) {
            System.out.println("Quantia exata! Não será necessário troco :)");
            return BigDecimal.ZERO;
        } else {
            BigDecimal troco = valorPagoEmDinheiro.subtract(valorPedido);
            System.out.println("O seu troco é R$" + troco + ".");
            return troco;
        }
    }
    public static void calcularMenorQuantidadeDeNotas(BigDecimal troco) {
        BigDecimal cemReais = new BigDecimal(100);
        BigDecimal cinquentaReais = new BigDecimal(50);
        BigDecimal vinteReais = new BigDecimal(20);
        BigDecimal dezReais = new BigDecimal(10);
        BigDecimal cincoReais = new BigDecimal(5);
        BigDecimal doisReais = new BigDecimal(2);
        BigDecimal umReal = new BigDecimal(1);
        BigDecimal cinquentaCentavos = new BigDecimal("0.5");
        BigDecimal vinteECincoCentavos = new BigDecimal("0.25");
        BigDecimal dezCentavos = new BigDecimal("0.10");
        BigDecimal cincoCentavos = new BigDecimal("0.05");
        BigDecimal umCentavo = new BigDecimal("0.01");

        BigDecimal[] valores = {cemReais, cinquentaReais, vinteReais, dezReais, cincoReais, doisReais, umReal, cinquentaCentavos, vinteECincoCentavos, dezCentavos, cincoCentavos, umCentavo};
        String[] notasEMoedas = {"Nota(s) de R$100", "Nota(s) de R$50", "Nota(s) de R$20", "Nota(s) de R$10", "Nota(s) de R$5", "Nota(s) de R$2", "Moeda(s) de R$1", "Moeda(s) de R$0.50", "Moeda(s) de R$0.25", "Moeda(s) de R$0.10", "Moeda(s) de R$0.05", "Moeda(s) de R$0.01"};

        System.out.println("Menor quantidade de notas e moedas para o troco de R$" + troco + " é:");

        for (int i = 0; i < valores.length; i++) {
            BigDecimal[] resultado = troco.divideAndRemainder(valores[i]);
            int quantidade = resultado[0].intValue();
            if (quantidade > 0) {
                System.out.println(quantidade + " " + notasEMoedas[i]);
            }
            troco = resultado[1];
        }
    }
}

