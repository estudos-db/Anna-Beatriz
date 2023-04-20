package exercicio14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
public class ConversorDoTempoEmSegundosTest {
    @Test
    @DisplayName("Deve calcular os segundos inseridos pelo usuário apenas em horas.")

    void testCalcularHoras() {
        int segundos = 7023;
        int horasEsperadas = 1;
        int horasCalculadas = ConversorDoTempoEmSegundos.calcularHoras(segundos);
        assertEquals(horasEsperadas, horasCalculadas);
    }

    @Test
    @DisplayName("Deve calcular os minutos exibidos na tela após a exibição das horas equivalentes.")
    void testCalcularMinutos() {
        int segundos = 7023;
        int minutosEsperados = 57;
        int minutosCalculados = ConversorDoTempoEmSegundos.calcularMinutos(segundos);
        assertEquals(minutosEsperados, minutosCalculados);
    }

    @Test
    @DisplayName("Deve calcular os segundos restantes que não formam um minuto completo.")
    void testCalcularSegundosRestantesQueNaoFormamUmMinutoCompleto() {
        int segundos = 7023;
        int segundosRestantesEsperados = 3;
        int segundosRestantesCalculados = ConversorDoTempoEmSegundos.calcularSegundosRestantesQueNaoFormamUmMinutoCompleto(segundos);
        assertEquals(segundosRestantesEsperados, segundosRestantesCalculados);
    }

    @Test
    @DisplayName("Deve simular a entrada de dados do usuário.")
    void testLerSegundosInseridosPeloUsuario() {
        Scanner sc = new Scanner("7023");
        int segundosEsperados = 7023;
        int segundosLidos = ConversorDoTempoEmSegundos.lerSegundosInseridosPeloUsuario(sc);
        assertEquals(segundosEsperados, segundosLidos);
    }

    @Test
    @DisplayName("Deve exibir o resultado inserido pelo usuário.")
    void testExibirTempo() {
        int segundos = 7023;
        String resultadoEsperado = "7023 segundos equivalem a: 1h,57min e 3seg.";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ConversorDoTempoEmSegundos.exibirConversao(segundos);
        String resultadoReal = outContent.toString().trim();
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
