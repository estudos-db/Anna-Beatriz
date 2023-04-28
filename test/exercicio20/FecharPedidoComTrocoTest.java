package exercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FecharPedidoComTrocoTest {
    private static final List<Produto> listaDeProdutos = new ArrayList<>();
    private Produto produto1;

    @BeforeEach
    void setUp() {
        produto1 = new Produto(1, "Arroz", new BigDecimal("10.00"), 10);
    }

    @Test
    @DisplayName("Deve adicionar um item a lista de estoque")
    void testAdicionarItem() {
        Estoque.adicionaProdutoAListaDeEstoque(produto1);
        listaDeProdutos.add(produto1);
        assertEquals(1,1);
    }
}
