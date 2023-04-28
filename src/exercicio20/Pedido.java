package exercicio20;

import java.math.BigDecimal;
import java.util.*;

public class Pedido {
    private final List<Item> listaDeItens = new ArrayList<>();
    private BigDecimal valorTotal = BigDecimal.ZERO;
    private final Scanner scanner = new Scanner(System.in);

    public void adicionarItem() {
        Produto produto = encontrarProduto();
        int quantidadeRequerida = receberQuantidadeProdutoDoTeclado();
        Estoque.temEstoqueOuNao(produto.getNome(), quantidadeRequerida);

        Item item = new Item(produto, quantidadeRequerida);
        Estoque.darBaixaEmEstoque(produto.getNome(), quantidadeRequerida);

        adicionarItemALista(item);
        calcularValorTotal();
    }

    public Produto encontrarProduto() {
        Produto produto = null;
        while (produto == null) {
            System.out.println("Digite o nome do produto que você quer comprar:");
            String nomeProduto = scanner.nextLine();
            if (Estoque.encontraProdutoPeloNome(nomeProduto) == null) {
                scanner.nextLine();
                System.out.println("Produto não encontrado no estoque. Por favor, digite um produto válido.");
            } else  {
                produto = Estoque.encontraProdutoPeloNome(nomeProduto);
            }
        }
        return produto;
    }
    public int receberQuantidadeProdutoDoTeclado() {
        System.out.println("Quantos itens desse produto você deseja comprar?");
        return scanner.nextInt();
    }

    public void adicionarItemALista(Item item) {
        listaDeItens.add(item);
    }

    public void calcularValorTotal() {
        valorTotal = listaDeItens.stream()
                .map(Item::getValorDoItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void imprimirPedido() {
        System.out.println("Compra finalizada! Status atual do produto:");
        System.out.println(this);

    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "itens no pedido=" + listaDeItens +
                '}';
    }
}
