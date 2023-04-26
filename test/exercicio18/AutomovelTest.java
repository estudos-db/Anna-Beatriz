package exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutomovelTest {
    @Test
    @DisplayName("Deve ligar um carro até então desligado chamando o método ligar.")
    public void testLigar() {
        Automovel automovel = new Automovel("Chevrolet", "Onix", 2012, "Branco");
        assertFalse(automovel.ligado);
        automovel.ligar();
        assertTrue(automovel.ligado);
    }
    @Test
    @DisplayName("Deve acelerar o carro e atualizar a velocidade atual em 50.")
    public void testAcelerar() {
        Automovel automovel = new Automovel("Chevrolet", "Onix", 2012, "Branco");
        automovel.ligar();
        automovel.acelerar(50);
        assertEquals(50, automovel.getVelocidadeAtual());
    }
    @Test
    @DisplayName("Deve frear o carro e diminuir a velocidade atual para 30 após frear em 20.")
    public void testFrear() {
        Automovel automovel = new Automovel("Chevrolet", "Onix", 2012, "Branco");
        automovel.ligar();
        automovel.acelerar(50);
        automovel.frear(20);
        assertEquals(30, automovel.getVelocidadeAtual());
    }
}
