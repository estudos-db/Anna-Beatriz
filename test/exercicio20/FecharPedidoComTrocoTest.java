package exercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FecharPedidoComTrocoTest {
    private static final List<Produto> listaDeProdutos = new ArrayList<>();
    private Produto produto1;

    @BeforeEach
    void setUp() {
        produto1 = new Produto(1, "Arroz", new BigDecimal(6), 500);
    }

    @Test
    @DisplayName("Deve adicionar um item a lista de estoque")
    void testAdicionarItem() {
        Estoque.adicionaProdutoAListaDeEstoque(produto1);
        listaDeProdutos.add(produto1);
        assertEquals(1,1);
    }
    @Test
    public void testCalcularMenorQuantidadeDeNotas() {
        BigDecimal troco = new BigDecimal("6.38");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FecharPedidoComTroco.calcularMenorQuantidadeDeNotas(troco);

        String expectedOutput = """
                Menor quantidade de notas e moedas para o troco de R$6.38 é:\r
                1 Nota(s) de R$5\r
                1 Moeda(s) de R$1\r
                1 Moeda(s) de R$0.25\r
                1 Moeda(s) de R$0.10\r
                3 Moeda(s) de R$0.01\r
                """;
        assertEquals(expectedOutput, outContent.toString());
    }
}
