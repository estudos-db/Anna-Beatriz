package exercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {
    private List<Produto> listaDeProdutos;

    @BeforeEach
    public void setUp() {
        listaDeProdutos = new ArrayList<>();
    }
    @Test
    @DisplayName("Deve dar baixa em estoque")
    public void testDarBaixaEmEstoque() {
        Produto produto = new Produto(1, "Arroz", new BigDecimal("10.00"), 10);
        listaDeProdutos.add(produto);
        Estoque.darBaixaEmEstoque("Arroz", 5);
        assertEquals(10, produto.getQuantidadeEmEstoque());
    }
    @Test
    @DisplayName("Deve verificar se o produto arroz possui estoque suficiente ou não.")
    public void testTemEstoqueOuNao() {
        Produto produto = new Produto(1, "Arroz", new BigDecimal("10.00"), 5);
        listaDeProdutos.add(produto);
        Estoque.temEstoqueOuNao("Arroz", 6);
        assertEquals(5, produto.getQuantidadeEmEstoque());
    }
    @Test
    @DisplayName("Deve encontrar o produto pelo nome digitado pelo usuário")
    public void testEncontraProdutoPeloNome() {
        Produto produto = new Produto(1, "Arroz", new BigDecimal("10.00"), 10);
        listaDeProdutos.add(produto);
        assertNotNull(Estoque.encontraProdutoPeloNome("Arroz"));
    }
    @Test
    @DisplayName("Deve adicionar o produto cadastrado à lista de estoque")
    public void testAdicionaProdutoAListaDeEstoque() {
        Produto produto = new Produto(1, "Arroz", new BigDecimal("10.00"), 10);
        Estoque.adicionaProdutoAListaDeEstoque(produto);
        assertFalse(listaDeProdutos.contains(produto));
    }
}
