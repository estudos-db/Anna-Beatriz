package exercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {


    @BeforeEach
    public void setUp() {
        InicializarEstoque.estoqueInitializer();
    }
    @Test
    @DisplayName("Deve dar baixa em estoque")
    public void testDarBaixaEmEstoque() {
        Estoque.darBaixaEmEstoque("Arroz", 5);
        assertEquals(495, Estoque.encontraProdutoPeloNome("Arroz").getQuantidadeEmEstoque());
    }

    @Test
    @DisplayName("Deve verificar se o produto arroz possui estoque suficiente ou não.")
    public void testTemEstoqueOuNao() {
        Estoque.temEstoqueOuNao("Arroz", 5);
        assertEquals(495, Estoque.encontraProdutoPeloNome("Arroz").getQuantidadeEmEstoque());
    } //verifica se tem estoque o suficiente (no caso, sim) e dá baixa
    @Test
    @DisplayName("Deve encontrar o produto pelo nome digitado pelo usuário")
    public void testEncontraProdutoPeloNome() {
        assertNotNull(Estoque.encontraProdutoPeloNome("Arroz"));
    }
    @Test
    @DisplayName("Deve adicionar o produto cadastrado à lista de estoque")
    public void testAdicionaProdutoAListaDeEstoque() {
        Produto produto = new Produto(11, "Whey Protein", new BigDecimal(100), 50);
        Estoque.adicionaProdutoAListaDeEstoque(produto);
        assertNotNull(Estoque.encontraProdutoPeloNome(produto.getNome()));
    }
}
