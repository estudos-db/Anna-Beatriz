package exercicio20;

import org.junit.jupiter.api.BeforeEach;
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
    Pedido pedido = new Pedido();
    @BeforeEach
    public void setUp(){
        pedido.limparListaDeItens();
    }
    @Test
    @DisplayName("Deve adicionar um item")
    public void testAdicionarItem() {
        // criação de um produto
        Produto produto = new Produto(1, "Arroz", BigDecimal.valueOf(10), 20);

        Pedido pedido = new Pedido();
        Item item = new Item(produto, 5);
        pedido.adicionarItemALista(item);
        pedido.calcularValorTotal();

        assertEquals(item.getProduto().getNome(), pedido.getListaDeItens().get(0).getProduto().getNome()); // verifica se o produto do item é o mesmo que foi criado acima
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
        assertEquals(1, pedido.getListaDeItens().size());
        assertTrue(pedido.getListaDeItens().contains(itemMock));
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


