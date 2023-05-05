package exercicio20;

import java.math.BigDecimal;

public class InicializarEstoque {
    public static void estoqueInitializer(){
        Produto produto1 = new Produto(1, "Arroz", BigDecimal.valueOf(6), 500);
        Produto produto2 = new Produto(2, "Feijão", BigDecimal.valueOf(8), 500);
        Produto produto3 = new Produto(3, "Tomate", BigDecimal.valueOf(11.99), 150);
        Produto produto4 = new Produto(4,"Alface", BigDecimal.valueOf(5.49), 500);
        Produto produto5 = new Produto(5,"Beterraba", BigDecimal.valueOf(12.99),100);
        Produto produto6 = new Produto(6,"Chocolate", BigDecimal.valueOf(11), 300);
        Produto produto7 = new Produto(7,"Sal",BigDecimal.valueOf(8), 200);
        Produto produto8 = new Produto(8,"Açúcar", BigDecimal.valueOf(4.47),50);
        Produto produto9 = new Produto(9,"Leite", BigDecimal.valueOf(12),50);
        Produto produto10 = new Produto(10,"Granola", BigDecimal.valueOf(15),50);

        Estoque.adicionaProdutoAListaDeEstoque(produto1);
        Estoque.adicionaProdutoAListaDeEstoque(produto2);
        Estoque.adicionaProdutoAListaDeEstoque(produto3);
        Estoque.adicionaProdutoAListaDeEstoque(produto4);
        Estoque.adicionaProdutoAListaDeEstoque(produto5);
        Estoque.adicionaProdutoAListaDeEstoque(produto6);
        Estoque.adicionaProdutoAListaDeEstoque(produto7);
        Estoque.adicionaProdutoAListaDeEstoque(produto8);
        Estoque.adicionaProdutoAListaDeEstoque(produto9);
        Estoque.adicionaProdutoAListaDeEstoque(produto10);
    }
}
