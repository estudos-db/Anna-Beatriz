package exercicio20;

import java.util.ArrayList;

public class Estoque {

    private static ArrayList<Produto> catalogo = new ArrayList<>();

    public static void inicializaEstoque() {
        Produto produto1 = new Produto(1, "Arroz", 7.0, 50);
        Produto produto2 = new Produto(2, "Feijão", 8.0, 40);
        Produto produto3 = new Produto(3, "Macarrão", 6.0, 30);

        catalogo.add(produto1);
        catalogo.add(produto2);
        catalogo.add(produto3);
    }

    public static Produto encontraProdutoPorNome(String nomeProduto) {
        for (Produto produto : catalogo) {
            if (produto.getNomeProduto().equals(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }
    public static boolean cadastraProduto(Produto produto) {
        if (catalogo.contains(produto)) {
            return false;
        } else {
            catalogo.add(produto);
            return true;
        }
    }

    public static void imprimeCatalogoDoEstoque() {
        System.out.println("CATALOGO DE PRODUTOS:");
        for (Produto produto : catalogo) {
            System.out.println(produto.toString());
        }
    }

    public static void darBaixaEmEstoquePorNome(String nome, int quantidade) {
        Produto produto = encontraProdutoPorNome(nome);
        if (produto == null) {
            System.out.println("Produto não encontrado no estoque.");
            return;
        }
        if (produto.getQuantidadeEmEstoque() < quantidade) {
            System.out.println("Não há quantidade suficiente do produto.");
            return;
        }
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
        System.out.println("Estoque atualizado com sucesso.");
    }


    public static boolean temEstoqueOuNao(Produto produto, int quantidade) {
        for (Produto produto2 : catalogo) {
            if (produto2.equals(produto)) {
                produto2.getQuantidadeEmEstoque();
                return false;
            }
        }
     return true;
    }
}
