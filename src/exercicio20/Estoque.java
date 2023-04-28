package exercicio20;

import java.math.BigDecimal;
import java.util.*;

public class Estoque {

    private static final List<Produto> listaDeProdutos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void cadastrarProduto() {
        int idProduto = listaDeProdutos.size() + 1;

        System.out.println("Qual o nome do produto que você deseja cadastrar?");
        String nomeProduto = scanner.next();
        System.out.println("Qual o preço desse produto?");
        BigDecimal precoProduto = scanner.nextBigDecimal();
        System.out.println("Qual a quantidade que você deseja pôr desse produto em estoque?");
        int quantidadeEmEstoque = scanner.nextInt();

        Produto produto = new Produto(idProduto, nomeProduto, precoProduto, quantidadeEmEstoque);
        listaDeProdutos.add(produto);

        System.out.println("Produto " + produto + " cadastrado com sucesso!");
    }

    public static void darBaixaEmEstoque(String nomeProduto, int quantidadePraDarBaixa) {
        for (Produto produto : listaDeProdutos){
            if (produto.getNome().equals(nomeProduto)){
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() -quantidadePraDarBaixa);
            }
        }
    }
    public static void temEstoqueOuNao(String nomeProduto, int quantidadeParaDarBaixa) {
        Produto produto = encontraProdutoPeloNome(nomeProduto);
        if (produto.getQuantidadeEmEstoque() < quantidadeParaDarBaixa) {
            System.out.println("O produto " + produto.getNome() + " não possui estoque suficiente. Reveja o estoque do mercado e insira uma quantidade válida.");
        }
    }
    public static Produto encontraProdutoPeloNome(String nome) {
        Optional<Produto> produtoEncontrado = listaDeProdutos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst();
        return produtoEncontrado.orElse(null);
    }
    public static Produto encontraProdutoDoEstoquePeloId(int id) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; // caso não encontre o produto com o id informado
    }

    public static void adicionaProdutoAListaDeEstoque(Produto produto) {
        listaDeProdutos.add(produto);
    }

    public static void mostrarEstoque() {
        System.out.println("============ESTOQUE DO MERCADO============");
        listaDeProdutos.forEach(System.out::println);
    }
}

