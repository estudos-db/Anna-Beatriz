package exercicio20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PedidoTest {
    @Mock
    Item itemMock;
    @Test
    @DisplayName("Deve adicionar um item")
    public void testAdicionarItem() {
        // criação de um produto
        Produto produto = new Produto(1, "Arroz", BigDecimal.valueOf(10), 20);
        Estoque.adicionaProdutoAListaDeEstoque(produto);

        // simulação de entrada de dados do usuário
        ByteArrayInputStream in = new ByteArrayInputStream("Arroz\n5".getBytes());
        System.setIn(in);

        Pedido pedido = new Pedido();
        pedido.adicionarItem();

        List<Item> listaDeItens = pedido.getListaDeItens();
        assertEquals(1, listaDeItens.size()); // verifica se o item foi adicionado à lista de itens
        Item item = listaDeItens.get(0);
        assertEquals(produto, item.getProduto()); // verifica se o produto do item é o mesmo que foi criado acima
        assertEquals(5, item.getQuantidade()); // verificando se a quantidade do item é a mesma que foi digitada pelo usuário
        assertEquals(BigDecimal.valueOf(50), pedido.getValorTotal());
    }
    @Test
    @DisplayName("Deve receber a quantidade do produto do teclado do usuário simulando um Scanner.")
    public void testReceberQuantidadeProdutoDoTeclado() {
        ByteArrayInputStream in = new ByteArrayInputStream("10\n".getBytes());
        System.setIn(in);

        // mock do scanner
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(10);

        // novo pedido com o mock do scanner
        Pedido pedido = new Pedido();
        int quantidade = pedido.receberQuantidadeProdutoDoTeclado();
        assertEquals(10, quantidade);
    }
    @Test
    @DisplayName("Deve adicionar um item à lista.")
    public void testAdicionarItemALista() {
        Pedido pedido = new Pedido();
        pedido.adicionarItemALista(itemMock);
        List<Item> listaDeItens = pedido.getListaDeItens();
        assertEquals(1, listaDeItens.size());
        assertTrue(listaDeItens.contains(itemMock));
    }
    @Test
    @DisplayName("Deve calcular o valor total do pedido.")
    public void testCalcularValorTotal() {
        Item item1 = new Item(new Produto(1, "Arroz", BigDecimal.valueOf(6), 10), 5);
        Item item2 = new Item(new Produto(2, "Feijão", BigDecimal.valueOf(8), 10), 3);
        Pedido pedido = new Pedido();
        pedido.adicionarItemALista(item1);
        pedido.adicionarItemALista(item2);
        pedido.calcularValorTotal();
        assertEquals(BigDecimal.valueOf(54), pedido.getValorTotal());
    }
}


