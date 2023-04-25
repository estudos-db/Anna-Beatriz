package exercicio20;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private List<Item> listaDeItens;
    private BigDecimal valorTotal;

    public Pedido() {
        this.listaDeItens = new ArrayList<>();
        this.valorTotal = BigDecimal.ZERO;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionaItemNaLista(Produto produto, int quantidade) {
        Item item = new Item(produto, BigDecimal.valueOf(produto.getPreco()), quantidade);
        listaDeItens.add(item);
    }


    public void calculaValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : listaDeItens) {
            total = total.add(item.getValorDoItem());
        }
        this.valorTotal = total;
    }

    public void imprimePedido() {
        System.out.println("====> PEDIDO <====");
        for (Item item : listaDeItens) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto().getNomeProduto() + " - " + item.getValorDoItem());
        }
    }

    public void imprimeValorTotal() {
        System.out.println("VALOR TOTAL: " + valorTotal);
    }

    public void adicionaItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade desejada: ");
        int quantidade = scanner.nextInt();
        Produto produto = Estoque.encontraProdutoPorNome(nome);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        Estoque.temEstoqueOuNao(produto, quantidade);
        adicionaItemNaLista(produto, quantidade);
        Estoque.darBaixaEmEstoquePorNome(nome, quantidade);
        System.out.println("Item adicionado com sucesso.");
    }

    public void recebeQuantidadeDoTeclado(int quantidade) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantidade desejada: ");
        quantidade = scanner.nextInt();
    }
    public void limparCarrinho() {
        listaDeItens.clear();
        valorTotal = BigDecimal.ZERO;
        System.out.println("Carrinho limpo com sucesso.");
    }
}
