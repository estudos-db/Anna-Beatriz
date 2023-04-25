package exercicio20;

import java.util.Scanner;
public class MenuMain {
    private static Scanner scanner = new Scanner(System.in);
    private static Pedido pedido = new Pedido();


    public static void main(String[] args) {
        Estoque.inicializaEstoque();
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> mostrarEstoque();
                case 2 -> adicionarItemAoCarrinho();
                case 3 -> imprimirPedido();
                case 4 -> limparCarrinho();
                case 5 -> cadastrarProduto();
                case 6 -> continuar = false;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n==== MENU ====");
        System.out.println("1. Mostrar Estoque");
        System.out.println("2. Adicionar Item ao Carrinho");
        System.out.println("3. Imprimir Pedido");
        System.out.println("4. Limpar Carrinho");
        System.out.println("5. Cadastrar Produto");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void mostrarEstoque() {
        System.out.println("\n==== ESTOQUE ====");
        Estoque.imprimeCatalogoDoEstoque();
    }

    public void adicionarItemAoCarrinho() {
        Scanner scanner = new Scanner(System.in);
        boolean produtoEncontrado = false;
        Produto produto = null;

        while (!produtoEncontrado) {
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scanner.nextLine();

            for (Produto p : estoque.keySet()) {
                if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                    produto = p;
                    produtoEncontrado = true;
                    break;
                }
            }

            if (!produtoEncontrado) {
                System.out.println("Produto não encontrado no estoque.");
            }
        }

        System.out.print("Digite a quantidade que deseja adicionar ao carrinho: ");
        int quantidade = scanner.nextInt();

        if (quantidade > produto.getQuantidadeEmEstoque()) {
            System.out.println("Não há quantidade suficiente no estoque.");
            return;
        }
        CarrinhoItem item = new CarrinhoItem(produto, quantidade);
        carrinho.add(item);
        System.out.println("Item adicionado ao carrinho com sucesso!");
    }
    private static void imprimirPedido() {
        System.out.println("\n==== PEDIDO ====");
        pedido.imprimePedido();
        pedido.imprimeValorTotal();
    }

    private static void limparCarrinho() {
        System.out.println("\nCarrinho limpo.");
        pedido.limparCarrinho();
    }

    private static void cadastrarProduto() {
        System.out.println("\n==== CADASTRAR PRODUTO ====");
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.next();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        int id = scanner.nextInt();
        Produto produto = new Produto(id,nome,preco,quantidade);
        boolean cadastrado = Estoque.cadastraProduto(produto);
        if (cadastrado) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Produto já cadastrado.");
        }
    }
}

