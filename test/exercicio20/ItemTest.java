package exercicio20;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ItemTest {
    private Item item;

    @BeforeEach
    public void setUp() {
        Produto produto = new Produto(1, "Arroz", BigDecimal.valueOf(5.0), 20);
        int quantidade = 2;
        item = new Item(produto, quantidade);
    }

    @Test
    @DisplayName("Deve calcular o valor total do item")
    public void testCalcularValorTotal() {
        item.calcularValorTotal();
        assertEquals(BigDecimal.valueOf(10.0), item.getValorDoItem());
    }

    @Test
    public void testGetProduto() {
        assertNotNull(item.getProduto());
    }

    @Test
    public void testSetProduto() {
        Produto novoProduto = new Produto(1, "Feijão", BigDecimal.valueOf(6.0), 20);
        item.setProduto(novoProduto);
        assertEquals(novoProduto, item.getProduto());
    }

}

