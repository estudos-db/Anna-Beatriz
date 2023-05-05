package exercicio20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FecharPedidoComTrocoTest {
    @Test
    public void testCalcularTroco() {
        BigDecimal valorPedido = new BigDecimal("25.00");
        BigDecimal valorPagoEmDinheiro = new BigDecimal("50.00");

        BigDecimal trocoRecebido = new BigDecimal("25.00");

        BigDecimal trocoCalculado = FecharPedidoComTroco.calcularTroco(valorPedido, valorPagoEmDinheiro);

        Assertions.assertEquals(trocoRecebido, trocoCalculado);
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
