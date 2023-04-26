package exercicio20;

import java.math.BigDecimal;
import java.util.*;

public class Estoque {

    private static final List<Produto> listaDeProdutos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void cadastrarProduto() {
        int idProduto = listaDeProdutos.size() + 1;

        System.out.println("Qual o nome do produto a ser cadastrado?");
        String nomeProduto = scanner.next();
        System.out.println("Qual o preço desse produto?");
        BigDecimal precoProduto = scanner.nextBigDecimal();
        System.out.println("Qual a quantidade que você deseja pôr desse produto em estoque?");
        int quantidadeEmEstoque = scanner.nextInt();

        Produto produto = new Produto(idProduto, nomeProduto, precoProduto, quantidadeEmEstoque);
        listaDeProdutos.add(produto);

        System.out.println("Produto " + produto.toString() + " cadastrado com sucesso");
    }

    public static void darBaixaEmEstoque(String nomeProduto, int quantidadeParaDarBaixa) {
        Produto produto = encontraProdutoPeloNome(nomeProduto);

        if (produto.getQuantidadeEmEstoque() < quantidadeParaDarBaixa) {
            throw new NoSuchElementException("Esse produto tem estoque insuficiente.");
        }

        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
    }
    public static void temEstoqueOuNao(String nomeProduto, int quantidadeParaDarBaixa) {
        Produto produto = encontraProdutoPeloNome(nomeProduto);
        boolean temEstoque = produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa;
        if (!temEstoque) {
            System.out.println("Produto " + produto.getNome() + " não possui estoque suficiente.");
        }
    }
    public static Produto encontraProdutoPeloNome(String nome) {
        Optional<Produto> produtoEncontrado = listaDeProdutos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst();
        return produtoEncontrado.orElse(null);
    }

    public static void addProdutoToListaDeProdutos(Produto produto) {
        listaDeProdutos.add(produto);
    }

    public static void mostrarEstoque() {
        System.out.println("=====ESTOQUE DO MERCADO====");
        listaDeProdutos.forEach(System.out::println);
    }
}

