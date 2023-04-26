package exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarroAutomaticoTest {
    @Test
    @DisplayName("Deve inciar com o carro desligado e mantê-lo desligado até que o freio seja pressionado.")
    public void testLigar() {
        CarroAutomatico carro = new CarroAutomatico("Fiat", "Uno", 2020, "Vermelho");
        assertFalse(carro.isLigado(), "O carro deve estar desligado.");

        carro.ligar();
        assertFalse(carro.isLigado(), "O carro deveria estar desligado pois o freio não foi pressionado.");

        carro.setFreioPressionado(true);
        carro.ligar();
        assertTrue(carro.isLigado(), "O carro deve estar ligado pois o freio foi pressionado.");
    }

    @Test
    @DisplayName("Deve atualizar a velocidade atual do carro.")
    public void testAcelerar() {
        CarroAutomatico carro = new CarroAutomatico("Fiat", "Uno", 2020, "Vermelho");
        carro.setFreioPressionado(true);
        carro.ligar();

        carro.acelerar(20);
        assertEquals(20, carro.getVelocidadeAtual(), "A velocidade atual é 20.");

        carro.acelerar(30);
        assertEquals(50, carro.getVelocidadeAtual(), "A velocidade atual é 50.");
    }

    @Test
    @DisplayName("Deve frear o carro, diminuindo sua velocidade atual para 30 e, logo após, parando o carro, deixando-o com uma velocidade de 0.")
    public void testFrear() {
        CarroAutomatico carro = new CarroAutomatico("Fiat", "Uno", 2020, "Vermelho");
        carro.setFreioPressionado(true);
        carro.ligar();

        carro.acelerar(50);
        carro.frear(20);
        assertEquals(30, carro.getVelocidadeAtual(), "A velocidade atual deveria ser 30.");

        carro.frear(30);
        assertEquals(0, carro.getVelocidadeAtual(), "A velocidade atual deveria ser 0.");
    }
}
