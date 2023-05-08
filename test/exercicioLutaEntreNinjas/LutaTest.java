package exercicioLutaEntreNinjas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LutaTest {
    private NinjaDeGenjutsu kakashi;
    private NinjaDeTaijutsu rockLee;
    private Jutsu chidori;
    private Jutsu chute;
    private Luta luta;
    @BeforeEach
    public void setUp() {
        kakashi = new NinjaDeGenjutsu("Kakashi");
        rockLee = new NinjaDeTaijutsu("Rock Lee");
        chidori = new Jutsu("Chidori", 10, 5);
        chute = new Jutsu("Chute", 5, 0);
        kakashi.aprenderJutsu(chidori.getNome(), chidori);
        rockLee.aprenderJutsu(chute.getNome(), chute);
        luta = new Luta(kakashi, rockLee);
    }
    @Test
    @DisplayName("Deve testar método que ordena o primeiro ninja a atacar")
    public void testOrdenarNinjas() {
        String resultado = luta.ordenarNinjas();
        assertTrue(resultado.contains("ninja"));
    }
    @Test
    @DisplayName("Deve verificar a mensagem exibida quando o ninja não tem mais chakra para atacar.")
    public void testVerificarStatus() {
        kakashi.consumirChakra(100);
        String resultado = luta.luta(kakashi, chidori, rockLee, false);
        String mensagemEsperada = """
                O ninja Kakashi usou Chidori para atacar!
                O ninja Rock Lee levou 10 de dano!
                O ninja Kakashi tem chakra insuficiente para continuar a luta.""";
        assertEquals(mensagemEsperada, resultado);
    }
    @Test
    @DisplayName("Deve verificar se o ninja tem jutsu ou não")
    public void testVerificarSeNinjaTemJutsu() {
        assertThrows(IllegalArgumentException.class, () -> {
            luta.verificarSeNinjaTemJutsu(kakashi, chute);
        });
    }
    @Test
    @DisplayName("Deve retornar mensagem informando que o ninja não tem mais vida para continuar a luta.")
    public void testVerificarSeNinjaEstaVivo() {
        rockLee.consumirVida(100);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            luta.verificarSeNinjaEstaVivo(rockLee);
        });
        String mensagemEsperada = "O ninja Rock Lee não possui mais vida para atacar.";
        String mensagemRecebida = exception.getMessage();
        assertTrue(mensagemRecebida.contains(mensagemEsperada));
    }
    @Test
    @DisplayName("Deve verificar a mensagem do ninja tentando desviar")
    public void testDesviar() {
        String resultado = luta.luta(kakashi, chidori, rockLee, true);
        assertTrue(resultado.contains("O ninja Rock Lee desviou") ||
                resultado.contains("O ninja Rock Lee não conseguiu desviar"));
    }
    @Test
    @DisplayName("Deve retornar a mensagem informando que o ninja levou dano.")
    public void testLevarDano() {
        String resultado = luta.luta(kakashi, chidori, rockLee, false);
        assertTrue(resultado.contains("O ninja Rock Lee levou 10 de dano"));
    }
}
