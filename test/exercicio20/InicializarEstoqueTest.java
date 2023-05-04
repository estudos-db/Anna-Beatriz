package exercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InicializarEstoqueTest {

    @BeforeEach
    public void setUp(){
        Estoque.limparEstoque();
    }
    @Test
    @DisplayName("Deve verificar se os produtos são corretamente adicionados no inicializador do Estoque.")
    public void testEstoqueInitializer() {
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


        assertEquals(produto1, Estoque.encontraProdutoDoEstoquePeloId(1));
        assertEquals(produto2, Estoque.encontraProdutoDoEstoquePeloId(2));
        assertEquals(produto3, Estoque.encontraProdutoDoEstoquePeloId(3));
        assertEquals(produto4, Estoque.encontraProdutoDoEstoquePeloId(4));
        assertEquals(produto5, Estoque.encontraProdutoDoEstoquePeloId(5));
        assertEquals(produto6, Estoque.encontraProdutoDoEstoquePeloId(6));
        assertEquals(produto7, Estoque.encontraProdutoDoEstoquePeloId(7));
        assertEquals(produto8, Estoque.encontraProdutoDoEstoquePeloId(8));
        assertEquals(produto9, Estoque.encontraProdutoDoEstoquePeloId(9));
        assertEquals(produto10, Estoque.encontraProdutoDoEstoquePeloId(10));
    }
}
