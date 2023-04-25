package exercicio20;

import java.util.Scanner;
public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Pedido pedido = new Pedido();
    public static void mostrarEstoque() {
        System.out.println("\n==== ESTOQUE ====");
        Estoque.imprimeCatalogoDoEstoque();
    }

    public static void adicionarItemAoCarrinho() {
        System.out.println("\n==== ADICIONAR ITEM AO CARRINHO ====");
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.next();
        Produto produto = Estoque.encontraProdutoPorNome(nomeProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado no estoque.");
            return;
        }
        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();
        pedido.adicionaItemNaLista(produto, quantidade);
        System.out.println("Item adicionado ao carrinho.");
    }

    public static void imprimirPedido() {
        System.out.println("\n==== PEDIDO ====");
        pedido.imprimePedido();
        pedido.imprimeValorTotal();
    }

    public static void limparCarrinho() {
        System.out.println("\nCarrinho limpo.");
        pedido.limparCarrinho();
    }
}


